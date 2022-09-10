package com.acme.delivery.converter;

import com.acme.delivery.domain.Order;
import com.acme.delivery.transfer.OrderDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrderConverter {
	private final ModelMapper mapper;

	public Order dtoToEntity(OrderDTO orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		return order;
	}

	public OrderDTO entityToDto(Order order) {

		ModelMapper mapper = new ModelMapper();
		OrderDTO map = mapper.map(order, OrderDTO.class);
		return map;

	}

	public List<OrderDTO> entityToDto(List<Order> orders) {

		return orders.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

}
