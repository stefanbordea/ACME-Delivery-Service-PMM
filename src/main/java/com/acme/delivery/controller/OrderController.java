package com.acme.delivery.controller;

import com.acme.delivery.converter.OrderConverter;
import com.acme.delivery.domain.Order;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.transfer.ApiResponse;
import com.acme.delivery.transfer.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController extends BaseController<Order> {
	private final OrderService orderService;
	private final OrderConverter orderConverter;

	@Override
	protected BaseService<Order> getBaseService() {
		return orderService;
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<Order>> newOrder(@RequestBody OrderDTO orderDto) {

		Order order = orderConverter.dtoToEntity(orderDto);
		Order createOrder = orderService.newOrder(order.getAccount(), order.getStore());
		orderService.addListOfItems(createOrder, order.getOrderItems());
		Order checkout = orderService.checkout(createOrder, order.getPaymentMethod());
		return new ResponseEntity<>(ApiResponse.<Order>builder().data(checkout).build(), HttpStatus.CREATED);
	}

	@GetMapping(params = "submitDate")
	public ResponseEntity<ApiResponse<List<OrderDTO>>> findBySubmitDate(@Valid @RequestParam Date submitDate) {
		final List<Order> orders = orderService.findBySubmitDate(submitDate);
		final List<OrderDTO> orderDTOS = orderConverter.entityToDto(orders);
		if (orderDTOS.isEmpty()) {
			throw new NoSuchElementException("There are no orders for this date");
		}
		return ResponseEntity.ok(ApiResponse.<List<OrderDTO>>builder().data(orderDTOS).build());
	}

}
