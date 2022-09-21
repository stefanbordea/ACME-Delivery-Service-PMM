package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.Store;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@org.springframework.core.annotation.Order(4)
@Component
@Profile("generate-orders")
@RequiredArgsConstructor
public class OrderSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final OrderService orderService;
	private final ProductService productService;
	private final AccountService accountService;
	private final StoreService storeService;

	@Override
	public void run(final String... args) throws Exception {

		Account account = accountService.findByEmail("iliaspapadakis48@gmail.com");
		Store storeOne = storeService.findByName("Goody's");
		logger.info("{}", account);
		Product firstProduct = productService.findBySerial("S199999999");
		Product secondProduct = productService.findBySerial("B1123006700");

		Order orderOne = orderService.newOrder(account, storeOne);

		orderService.addItem(orderOne, firstProduct, 1);
		orderService.addItem(orderOne, secondProduct, 1);

		orderService.checkout(orderOne, PaymentMethod.CARD);

		Account secondAccount = accountService.findByEmail("stefanbordea@stefanbordea.com");
		Store storeTwo = storeService.findStoreById(3L);
		logger.info("{}", account);
		Product thirdProduct = productService.findBySerial("D112389900");
		Product fourthProduct = productService.findBySerial("B1123006700");
		logger.info("This product");
		logger.info("{}", firstProduct);

		Order orderTwo = orderService.newOrder(secondAccount, storeTwo);

		orderService.addItem(orderTwo, thirdProduct, 1);
		orderService.addItem(orderTwo, fourthProduct, 2);

		orderService.checkout(orderTwo, PaymentMethod.CARD);

		Order orderThree = orderService.newOrder(account, storeTwo);

		orderService.addItem(orderThree, firstProduct, 8);
		orderService.addItem(orderThree, secondProduct, 3);

		orderService.checkout(orderThree, PaymentMethod.CARD);

		Store storeThree = storeService.findStoreById(2L);
		Product fifthProduct = productService.findBySerial("Y1002389934");

		Order orderFour = orderService.newOrder(secondAccount, storeThree);

		orderService.addItem(orderFour, fifthProduct, 2 );

		orderService.checkout(orderFour,PaymentMethod.CASH);

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
