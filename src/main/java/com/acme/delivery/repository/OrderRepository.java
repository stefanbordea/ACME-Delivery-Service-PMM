package com.acme.delivery.repository;

import com.acme.delivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findOrdersByAccount_Email(String email);

	//add custom methods in a few ours or days!
	@Query("SELECT o FROM Order o WHERE o.orderDate=:date")
	List<Order> findBySubmitDate(Date date);

}
