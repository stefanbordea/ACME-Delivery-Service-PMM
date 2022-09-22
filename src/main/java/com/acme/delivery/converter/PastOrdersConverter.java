package com.acme.delivery.converter;

import com.acme.delivery.domain.Order;
import com.acme.delivery.transfer.PastOrdersDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PastOrdersConverter {

	private final ModelMapper mapper;

	public Order dtoToEntity(PastOrdersDTO pastOrdersDto) {
		return mapper.map(pastOrdersDto, Order.class);
	}

	public PastOrdersDTO entityToDto(Order order) {
		return mapper.map(order, PastOrdersDTO.class);
	}

	public List<PastOrdersDTO> entityToDto(List<Order> orders) {
		return orders.stream().map(this::entityToDto).toList();
	}
}
