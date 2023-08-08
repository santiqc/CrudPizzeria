package com.pizza.pizzeria.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.pizza.pizzeria.persistence.entity.OrderEntity;

public interface OrdersRepository extends ListCrudRepository<OrderEntity, Integer> {

	List<OrderEntity> findByDateAfter(LocalDateTime today);

	List<OrderEntity> findByMethodIn(List<String> methods);

}
