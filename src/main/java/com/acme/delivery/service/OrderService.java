package com.acme.delivery.service;
import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import java.util.Date;
import java.util.List;


public interface OrderService extends BaseService<Order>
{
	Order newOrder(Account customer);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

	List<Order> findBySubmitDate(Date submitDate);






}
