package com.pizza.pizzeria.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.pizza.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    // You can define custom queries here if needed
}
