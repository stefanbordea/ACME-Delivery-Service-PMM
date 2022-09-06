package com.acme.delivery.convert;

import com.acme.delivery.domain.Order;
import com.acme.delivery.transfer.OrderDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrderConvert {
	private final ModelMapper mapper;

	public Order dtoToEntity(OrderDto orderDto) {
		Order order = mapper.map(orderDto, Order.class);
		return order;
	}

	public OrderDto entityToDto(Order order) {

		ModelMapper mapper = new ModelMapper();
		OrderDto map = mapper.map(order, OrderDto.class);
		return map;

	}

	public List<OrderDto> entityToDto(List<Order> orders) {

		return orders.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

}
