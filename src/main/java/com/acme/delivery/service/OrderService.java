package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.OrderItem;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.Store;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderService extends BaseService<Order> {
	Order newOrder(Account customer, Store store);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	List<Order> findOrdersByAccount_Email(String email);

	Order checkout(Order order, PaymentMethod paymentMethod);

	void addListOfItems(Order order, Set<OrderItem> items);

	List<Order> findOrdersByOrderDate(Date submitDate);

}
