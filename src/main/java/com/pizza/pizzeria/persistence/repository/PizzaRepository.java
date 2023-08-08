package com.pizza.pizzeria.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.pizza.pizzeria.persistence.entity.PizzaEntity;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
	// You can define custom queries here if needed

	List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

	List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
}
