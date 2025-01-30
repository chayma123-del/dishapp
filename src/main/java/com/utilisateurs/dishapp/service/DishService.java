package com.utilisateurs.dishapp.service;
import com.utilisateurs.dishapp.dto.DishDto;
import com.utilisateurs.dishapp.entity.Dish;

import java.util.List;

public  interface DishService {
    DishDto createDish(DishDto dishDto);
    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    Dish updateDish(Long id, DishDto dishDto);
    void deleteDish(Long id);
}
