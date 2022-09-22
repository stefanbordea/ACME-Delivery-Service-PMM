package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.OrderItem;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.Store;
import com.acme.delivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public JpaRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	@Override
	public Order newOrder(final Account customer, final Store store) {

		return Order.builder()
					.account(customer)
					.store(store)
					.orderItems(new HashSet<>()).build();
	}

	@Override
	public void addItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}
		boolean increasedQuantity = false;
		for (OrderItem item : order.getOrderItems()) {
			if (item.getProduct().getSerial().equals(product.getSerial())) {
				item.setQuantity(item.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}
		if (!increasedQuantity) {
			order.getOrderItems().add(newOrderItem(order, product, quantity));
		}

		logger.debug("Product[{}] added to Order[{}]", product, order);
	}

	private OrderItem newOrderItem(Order order, Product product, int quantity) {
		return OrderItem.builder().product(product).order(order).quantity(quantity).price(product.getPrice()).build();
	}

	@Override
	public void updateItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}
		order.getOrderItems().removeIf(item -> item.getProduct().getSerial().equals(product.getSerial()));
		order.getOrderItems().add(newOrderItem(order, product, quantity));

		logger.debug("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(final Order order, final Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(item -> item.getProduct().getSerial().equals(product.getSerial()));
		logger.debug("Product[{}] removed from Order[{}]", product, order);
	}

	@Override
	public List<Order> findOrdersByAccount_Email(final String email) {
		return orderRepository.findOrdersByAccount_Email(email);
	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null.");
			return true;
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public Order checkout(final Order order, final PaymentMethod paymentMethod) {
		if (!validate(order)) {
			logger.warn("Order should have customer, order items, and payment type defined before being able to " +
								"checkout the order.");
			return null;
		}

		// Set all order fields with proper values
		order.setStore(order.getStore());
		order.setSerial(getSerial(10));
		order.setPaymentMethod(paymentMethod);
		order.setDeliveryAddress(order.getAccount().getAddresses().stream().findFirst().get());
		order.setOrder_date(new Date());
		order.setTotalPrice(finalCost(order));

		return create(order);
	}

	@Override
	public void addListOfItems(final Order order, final Set<OrderItem> items) {
		for (OrderItem item : items) {

			addItem(order, item.getProduct(), item.getQuantity());
		}

	}

	String getSerial(int n) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getAccount() != null;
	}

	@Override
	public List<Order> findBySubmitDate(final Date submitDate) {
		return orderRepository.findBySubmitDate(submitDate);
	}

	private BigDecimal finalCost(Order order) {
		BigDecimal totalCost = new BigDecimal(0);

		for (OrderItem item : order.getOrderItems()) {
			totalCost = totalCost.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		logger.debug("Totalcost is {}", totalCost);
		return totalCost;
	}

}
