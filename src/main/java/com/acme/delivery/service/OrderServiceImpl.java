package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

	@Override
	public JpaRepository<Order, Long> getRepository() {
		return null;
	}

	@Override
	public Order initiateOrder(final Account customer) {
		return null;
	}

	@Override
	public void addItem(final Order order, final Product product, final int quantity) {

	}

	@Override
	public void updateItem(final Order order, final Product product, final int quantity) {

	}

	@Override
	public void removeItem(final Order order, final Product product) {

	}

	@Override
	public Order checkout(final Order order, final PaymentMethod paymentMethod) {
		return null;
	}

	@Override
	public List<Order> findBySubmitDate(final Date submitDate) {
		return null;
	}
}
