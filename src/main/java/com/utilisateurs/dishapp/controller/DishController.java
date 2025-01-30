package com.utilisateurs.dishapp.controller;
import com.utilisateurs.dishapp.dto.DishDto;
import com.utilisateurs.dishapp.entity.Dish;
import com.utilisateurs.dishapp.service.DishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController

@RequestMapping("/api/dishes")

public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public ResponseEntity<DishDto> createDish(@ModelAttribute DishDto dishDto) {
        return ResponseEntity.ok(dishService.createDish(dishDto));
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAllDishes() {
        return ResponseEntity.ok(dishService.getAllDishes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable Long id) {
        return ResponseEntity.ok(dishService.getDishById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long id, @ModelAttribute DishDto dishDto) {
        return ResponseEntity.ok(dishService.updateDish(id, dishDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
        return ResponseEntity.noContent().build();
    }
}