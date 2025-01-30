package com.utilisateurs.dishapp.repository;

import com.utilisateurs.dishapp.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
