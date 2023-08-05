package com.pizza.pizzeria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.pizzeria.persistence.entity.PizzaEntity;
import com.pizza.pizzeria.persistence.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
	private final PizzaRepository pizzaRepository;

	@Autowired
	public PizzaService(PizzaRepository pizzaRepository) {
		this.pizzaRepository = pizzaRepository;
	}

	public List<PizzaEntity> getAll() {
		return this.pizzaRepository.findAll();
	}

	public Optional<PizzaEntity> getById(int idPizza) {
		return this.pizzaRepository.findById(idPizza);
	}

	public Boolean existPizza(int idPizza) {
		return this.pizzaRepository.existsById(idPizza);
	}

	public PizzaEntity save(PizzaEntity pizzaEntity) {
		return this.pizzaRepository.save(pizzaEntity);
	}

	public PizzaEntity update(int idPizza, PizzaEntity updatedPizza) {
		if (existPizza(idPizza)) {
			updatedPizza.setIdPizza(idPizza); // Ensure the ID of the updated pizza matches the provided ID
			return this.pizzaRepository.save(updatedPizza);
		} else {
			// Throw an exception or handle the case when the pizza with the given ID is not
			// found.
			// For simplicity, we'll return null here.
			return null;
		}
	}

	public boolean delete(int idPizza) {
		if (this.existPizza(idPizza)) {

			this.pizzaRepository.deleteById(idPizza);
			return true;
		}
		return false;
	}
}