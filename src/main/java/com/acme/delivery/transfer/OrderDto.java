package com.acme.delivery.transfer;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.OrderItem;
import com.acme.delivery.domain.PaymentMethod;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDto {
	private Account account;
	private Address deliveryAddress;
	private PaymentMethod paymentMethod;
	private Set<OrderItem> orderItems;
}
