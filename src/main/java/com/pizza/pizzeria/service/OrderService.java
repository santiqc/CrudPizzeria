package com.pizza.pizzeria.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pizza.pizzeria.persistence.entity.OrderEntity;
import com.pizza.pizzeria.persistence.repository.OrdersRepository;

@Service
public class OrderService {

	private final OrdersRepository ordersRepository;

	private static final String DELIVERY = "D";
	private static final String CARRYOUT = "C";
	private static final String ON_SITE = "S";

	public OrderService(OrdersRepository ordersRepository) {
		this.ordersRepository = ordersRepository;
		// TODO Auto-generated constructor stub
	}

	public List<OrderEntity> getAll() {
		return this.ordersRepository.findAll();
	}

	public List<OrderEntity> getOrderToday() {
		LocalDateTime today = LocalDate.now().atTime(0, 0);
		return this.ordersRepository.findByDateAfter(today);
	}

	public List<OrderEntity> getOutsideOrder() {
		List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
		return this.ordersRepository.findByMethodIn(methods);
	}
}
