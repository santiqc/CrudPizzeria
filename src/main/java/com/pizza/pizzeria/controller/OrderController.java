package com.pizza.pizzeria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.pizzeria.persistence.entity.OrderEntity;
import com.pizza.pizzeria.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		// TODO Auto-generated constructor stub
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<OrderEntity>> getAll() {
		return ResponseEntity.ok(this.orderService.getAll());

	}

	@GetMapping("/today")
	public ResponseEntity<List<OrderEntity>> getOrderToday() {
		return ResponseEntity.ok(this.orderService.getOrderToday());

	}

	@GetMapping("/outside")
	public ResponseEntity<List<OrderEntity>> getOutsideOrder() {
		return ResponseEntity.ok(this.orderService.getOutsideOrder());

	}

}
