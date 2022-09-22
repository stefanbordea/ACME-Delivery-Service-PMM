package com.acme.delivery.repository;

import com.acme.delivery.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findBySerial(String serial);

	Product findByName(String name);

	@Query (value = "SELECT SUM(ORDER_ITEMS.QUANTITY) AS QUANTITY, ORDER_ITEMS.PRODUCT_ID AS PRODUCT_ID FROM " +
			"ORDER_ITEMS INNER" +
			" JOIN PRODUCTS ON ORDER_ITEMS.PRODUCT_ID=PRODUCTS.ID GROUP BY ORDER_ITEMS.PRODUCT_ID ORDER BY SUM" +
			"(ORDER_ITEMS.QUANTITY) DESC FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
	List<Map<Integer, Integer>> tenMostFamousProducts();
}
