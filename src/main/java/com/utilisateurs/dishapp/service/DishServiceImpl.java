package com.utilisateurs.dishapp.service;

import com.utilisateurs.dishapp.dto.DishDto;
import com.utilisateurs.dishapp.entity.Dish;
import com.utilisateurs.dishapp.repository.DishRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Value("${image.upload.dir}")
    private String uploadDir;

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public DishDto createDish(DishDto dishDto, MultipartFile image) {
        String imagePath = saveImage(image); // Sauvegarde de l'image
        dishDto.setImagePath(imagePath); // Mise à jour de l'image dans le DTO

        Dish dish = new Dish();
        dish.setName(dishDto.getName());
        dish.setDescription(dishDto.getDescription());
        dish.setPrice(dishDto.getPrice());
        dish.setImagePath(imagePath);
        dish.setDateAdded(LocalDate.now());
        dish.setActive(dishDto.getActive());

        Dish dishSaved = dishRepository.save(dish);

        return convertToDto(dishSaved);
    }


    private DishDto convertToDto(Dish dish) {
        return new DishDto(
                dish.getName(),
                dish.getDescription(),
                dish.getPrice(),
                dish.getActive(),
                dish.getImagePath()
        );
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found!"));
    }

    @Override
    public Dish updateDish(Long id, DishDto dishDto) {
        Dish dish = getDishById(id);

        if (dishDto.getImage() != null) {
            dish.setImagePath(saveImage(dishDto.getImage()));
        }

        dish.setName(dishDto.getName());
        dish.setDescription(dishDto.getDescription());
        dish.setPrice(dishDto.getPrice());
        dish.setActive(dishDto.getActive());

        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }



    // Méthode pour sauvegarder une image et retourner son chemin
    private String saveImage(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            return null;  // Retourne null au lieu de planter
        }
        try {
            String imagePath = uploadDir + File.separator + image.getOriginalFilename();
            Files.write(Paths.get(imagePath), image.getBytes());
            return imagePath;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }


    }

