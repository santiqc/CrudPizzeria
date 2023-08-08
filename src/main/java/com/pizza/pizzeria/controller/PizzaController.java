package com.pizza.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.pizzeria.persistence.entity.PizzaEntity;
import com.pizza.pizzeria.service.PizzaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
	private final PizzaService pizzaService;

	public PizzaController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	@GetMapping
	public ResponseEntity<List<PizzaEntity>> getAll() {
		return ResponseEntity.ok(this.pizzaService.getAll());
	}

	@GetMapping("/{idPizza}")
	public ResponseEntity<Optional<PizzaEntity>> getById(@PathVariable int idPizza) {
		return ResponseEntity.ok(this.pizzaService.getById(idPizza));
	}

	@GetMapping("/available")
	public ResponseEntity<List<PizzaEntity>> getAvailable() {
		return ResponseEntity.ok(this.pizzaService.getAvailable());
	}

	@GetMapping("/available/{name}")
	public ResponseEntity<List<PizzaEntity>> getByName(@PathVariable String name) {
		return ResponseEntity.ok(this.pizzaService.getByName(name));
	}

	@GetMapping("/with/{description}")
	public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String description) {
		return ResponseEntity.ok(this.pizzaService.getWith(description));
	}

	@GetMapping("/without/{description}")
	public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String description) {
		return ResponseEntity.ok(this.pizzaService.getWithout(description));
	}

	@PostMapping
	public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizzaEntity) {
		if (pizzaEntity.getIdPizza() == null || this.pizzaService.existPizza(pizzaEntity.getIdPizza())) {
			return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/{idPizza}")
	public ResponseEntity<PizzaEntity> update(@PathVariable int idPizza, @RequestBody PizzaEntity pizzaEntity) {
		if (idPizza > 0 && this.pizzaService.existPizza(idPizza)) {
			System.out.println("id:" + idPizza);
			return ResponseEntity.ok(this.pizzaService.update(idPizza, pizzaEntity));
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{idPizza}")
	public ResponseEntity<String> delete(@PathVariable int idPizza) {
		boolean response = this.pizzaService.delete(idPizza);
		if (response) {
			return ResponseEntity.ok("Eliminado con exito");

		}
		return ResponseEntity.badRequest().build();

	}

}