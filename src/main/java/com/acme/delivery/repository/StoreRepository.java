package com.acme.delivery.repository;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	Store findByName(String name);

	List<Store> findStoresByCategory(StoreCategory category);

	Store findStoreById(Long id);

	@Query(value = "SELECT SUM(ORDERS.STORE_ID) AS ORDERS_NUMBER, STORES.NAME FROM STORES_NAME INNER JOIN ORDERS ON " +
			"STORES" +
			".ID = ORDERS.STORE_ID GROUP BY STORES.NAME ORDER BY SUM(ORDERS.STORE_ID) DESC", nativeQuery = true)
	List<Map<Integer, String>> mostFamousStores();

	@Query(value = "SELECT COUNT(STORES.CATEGORY) AS CATEGORY , STORES.ID AS STORES FROM STORES INNER JOIN ORDERS ON STORES" +
			".ID = ORDERS.STORE_ID GROUP BY STORES.ID ORDER BY COUNT(STORES.CATEGORY) DESC", nativeQuery = true)
	List<Map <Integer, Integer>> mostFamousStoresByCategory();

}
