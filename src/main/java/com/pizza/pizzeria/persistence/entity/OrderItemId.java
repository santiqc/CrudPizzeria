package com.pizza.pizzeria.persistence.entity;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId implements Serializable {

	private Integer idOrder;
	private Integer idItem;


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return Objects.equals(idItem, other.idItem) && Objects.equals(idOrder, other.idOrder);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem, idOrder);
	}
}
