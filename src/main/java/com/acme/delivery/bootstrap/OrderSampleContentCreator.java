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

		Store storePizza = storeService.findStoreById(18L);
		Product pizzaOneProduct = productService.findBySerial("S199992999");
		Product pizzaTwoProduct = productService.findBySerial("S199993999");
		Product pizzaThreeProduct = productService.findBySerial("S199996999");


		Order orderPizza = orderService.newOrder(secondAccount, storePizza);

		orderService.addItem(orderPizza, pizzaOneProduct, 2 );
		orderService.addItem(orderPizza, pizzaTwoProduct, 4 );
		orderService.addItem(orderPizza, pizzaThreeProduct, 12);

		orderService.checkout(orderPizza,PaymentMethod.CASH);

		Store storeBurger = storeService.findStoreById(4L);
		Product burgerOneProduct = productService.findBySerial("S199999998");
		Product burgerTwoProduct = productService.findBySerial("S199999995");
		Product burgerThreeProduct = productService.findBySerial("S199999996");
		Product burgerFourProduct = productService.findBySerial("S199999994");


		Order orderBurger = orderService.newOrder(secondAccount, storeBurger);

		orderService.addItem(orderBurger, burgerOneProduct, 2 );
		orderService.addItem(orderBurger, burgerTwoProduct, 4 );
		orderService.addItem(orderBurger, burgerThreeProduct, 9);
		orderService.addItem(orderBurger, burgerFourProduct, 1);

		orderService.checkout(orderBurger,PaymentMethod.CARD);

		Store storeCocktail = storeService.findStoreById(20L);
		Product cocktailOneProduct = productService.findBySerial("S099999999");
		Product cocktailTwoProduct = productService.findBySerial("T199999999");
		Product cocktailThreeProduct = productService.findBySerial("U199999999");
		Product cocktailFourProduct = productService.findBySerial("P199999999");


		Order orderCocktail = orderService.newOrder(secondAccount, storeCocktail);

		orderService.addItem(orderCocktail, cocktailOneProduct, 17 );
		orderService.addItem(orderCocktail, cocktailTwoProduct, 22 );
		orderService.addItem(orderCocktail, cocktailThreeProduct, 30);
		orderService.addItem(orderCocktail, cocktailFourProduct, 5);

		orderService.checkout(orderCocktail,PaymentMethod.CARD);

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
