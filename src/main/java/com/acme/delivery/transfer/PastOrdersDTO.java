package com.acme.delivery.transfer;

import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.OrderItem;
import com.acme.delivery.domain.PaymentMethod;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class PastOrdersDTO {
	private String serial;
	private StoreForOrdersDTO store;
	private Date orderDate;
	private Address deliveryAddress;
	private Set<OrderItem> orderItems;
	private PaymentMethod paymentMethod;
}
