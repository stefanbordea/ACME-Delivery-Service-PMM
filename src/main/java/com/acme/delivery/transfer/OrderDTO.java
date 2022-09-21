package com.acme.delivery.transfer;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.OrderItem;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Store;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDTO {
	private Account account;
	private Store store;
	private Address deliveryAddress;
	private PaymentMethod paymentMethod;
	private Set<OrderItem> orderItems;
}
