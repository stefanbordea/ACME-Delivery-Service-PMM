package com.acme.delivery.transfer;

import com.acme.delivery.domain.Order;
import lombok.Data;

import java.util.Set;

@Data
public class AccountOrdersDto {
	private String email;
	private Set<Order> pastOrder;
}
