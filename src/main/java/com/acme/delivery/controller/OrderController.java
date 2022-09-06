package com.acme.delivery.controller;

import com.acme.delivery.convert.OrderConvert;
import com.acme.delivery.domain.Order;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.transfer.ApiResponse;
import com.acme.delivery.transfer.OrderDto;
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
	private final OrderConvert orderConvert;

	@Override
	protected BaseService<Order> getBaseService() {
		return orderService;
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse<Order>> NewOrder(@RequestBody OrderDto orderDto) {

		Order order = orderConvert.dtoToEntity(orderDto);
		Order createOrder = orderService.newOrder(order.getAccount());
		orderService.addListOfItems(createOrder, order.getOrderItems());
		Order checkout = orderService.checkout(createOrder, order.getPaymentMethod());
		return new ResponseEntity<>(ApiResponse.<Order>builder().data(checkout).build(), HttpStatus.CREATED);
	}

	@GetMapping(params = "submitdate")
	public ResponseEntity<ApiResponse<List<OrderDto>>> findBySumbitDate(@Valid @RequestParam Date submitdate) {
		final List<Order> orders = orderService.findBySubmitDate(submitdate);
		final List<OrderDto> orderDtos = orderConvert.entityToDto(orders);
		if (orderDtos.isEmpty()) {
			throw new NoSuchElementException("There are no orders for this date");
		}
		return ResponseEntity.ok(ApiResponse.<List<OrderDto>>builder().data(orderDtos).build());
	}

}
