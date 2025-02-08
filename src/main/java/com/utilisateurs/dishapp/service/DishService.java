package com.utilisateurs.dishapp.service;
import com.utilisateurs.dishapp.dto.DishDto;
import com.utilisateurs.dishapp.entity.Dish;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public  interface DishService {
    DishDto createDish(DishDto dishDto, MultipartFile image);

    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    Dish updateDish(Long id, DishDto dishDto);
    void deleteDish(Long id);

}