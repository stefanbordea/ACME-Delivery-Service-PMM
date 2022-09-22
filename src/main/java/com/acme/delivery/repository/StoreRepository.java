package com.acme.delivery.repository;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	Store findByName(String name);

	List<Store> findStoresByCategory(StoreCategory category);

	Store findStoreById(Long id);

	@Query(value = "SELECT SUM(ORDERS.STORE_ID) AS NUMBER_OF_ORDERS, STORES.NAME FROM STORES " +
			"INNER JOIN ORDERS ON STORES.ID = ORDERS.STORE_ID GROUP BY STORES.NAME " +
			"ORDER BY SUM(ORDERS.STORE_ID) DESC", nativeQuery = true)
	List<Map<Integer, String>> mostFamousStores();

	@Query(value = "SELECT COUNT(STORES.CATEGORY) AS NUMBER_OF_ORDERS_PER_CATEGORY , STORES.NAME AS STORES FROM STORES " +
			"INNER JOIN ORDERS ON STORES.ID = ORDERS.STORE_ID WHERE STORES.CATEGORY = :category GROUP BY STORES.NAME " +
			"ORDER BY COUNT(STORES.CATEGORY) DESC", nativeQuery = true)
	List<Map <Integer, String>> mostFamousStoresByCategory(@Param("category") String category);
}
