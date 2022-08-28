package com.acme.delivery.repository;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	Store findByName(String name);

	Store findStoreByCategories(Set<StoreCategory> categories);
}