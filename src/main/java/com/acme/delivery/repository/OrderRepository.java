package com.acme.delivery.repository;

import com.acme.delivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

	//add custom methods in a few ours or days!
	@Query("SELECT o FROM Order o WHERE o.order_date=:date")
	List<Order> findBySubmitDate(Date date);
}
