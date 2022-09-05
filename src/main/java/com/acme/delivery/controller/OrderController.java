package com.acme.delivery.controller;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Order;
import com.acme.delivery.domain.PaymentMethod;
import com.acme.delivery.domain.Product;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends BaseController<Order> {
	private final OrderService orderService;
	private final AccountService accountService;
	private final ProductService productService;

	@Override
	protected BaseService<Order> getBaseService() {
		return orderService;
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<Order>> NewOrder(@Email @RequestParam String email,
													   @RequestParam List<String> serial,
													   @RequestParam List<Integer> quantity,
													   @Valid @RequestParam PaymentMethod paymentMethod) {
		final Account customer = accountService.findByEmail(email);
		final Order order = orderService.newOrder(customer);

		for (int i = 0; i < serial.size(); i++) {
			final Product product = productService.findBySerial(serial.get(i));
			orderService.addItem(order, product, quantity.get(i));
		}

		final Order checkout = orderService.checkout(order, paymentMethod);
		return new ResponseEntity<>(ApiResponse.<Order>builder().data(checkout).build(), HttpStatus.CREATED);
	}

	@GetMapping(params = "submitdate")
	public ResponseEntity<ApiResponse<List<Order>>> findBySumbitDate(@Valid @RequestParam Date submitdate) {
		final List<Order> orders = orderService.findBySubmitDate(submitdate);

		if (orders.isEmpty()) {
			throw new NoSuchElementException("There are no orders for this date");
		}
		return ResponseEntity.ok(ApiResponse.<List<Order>>builder().data(orders).build());
	}

}
