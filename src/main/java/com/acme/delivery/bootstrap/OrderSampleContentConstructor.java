package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.convert.AccountConvert;
import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.transfer.AccountOrdersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@org.springframework.core.annotation.Order(3)
@Component
@Profile("generate-orders")
@RequiredArgsConstructor
public class OrderSampleContentConstructor extends BaseComponent implements CommandLineRunner {
	private final OrderService orderService;
	private final ProductService productService;
	private final AccountService accountService;

	@Override
	public void run(final String... args) throws Exception {
		Account account = accountService.findByEmail("iliaspapadakis48@gmail.com");
		logger.info("{}", account);
		Product firstProduct = productService.findBySerial("S199999999");
		Product secondProduct = productService.findBySerial("B1123006700");

		Order orderOne = orderService.newOrder(account);

		orderService.addItem(orderOne, firstProduct, 1);
		orderService.addItem(orderOne, secondProduct, 1);

		orderService.checkout(orderOne, PaymentMethod.CARD);

		Account secondAccount = accountService.findByEmail("stefanbordea@stefanbordea.com");
		logger.info("{}", account);
		Product thirdProduct = productService.findBySerial("D112389900");
		Product fourthProduct = productService.findBySerial("L1012309900");
		logger.info("This product");
		logger.info("{}", firstProduct);

		Order orderTwo = orderService.newOrder(secondAccount);

		orderService.addItem(orderTwo, thirdProduct, 1);
		orderService.addItem(orderTwo, fourthProduct, 2);

		orderService.checkout(orderTwo, PaymentMethod.CARD);



		List<Order> orders = orderService.findOrdersByAccount_Email(account.getEmail());

		for (Order order: orders){
			logger.info("Account with email {} has done the following orders: {} ",account.getEmail(),
						order.getSerial());
		}

		List<Order> orders2 = orderService.findOrdersByAccount_Email(secondAccount.getEmail());

		for (Order order: orders2){
			logger.info("Account with email {} has done the following orders: {} ",secondAccount.getEmail(),
						order.getSerial());
		}



	}
}
