package com.acme.delivery.service;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;

import java.util.List;

public interface StoreService extends BaseService<Store> {

	Store findByName(String name);

	List<Store> findByCategory(StoreCategory category);

	Store findStoreById(Long id);

	void populateStoreObject(Store convertedStore, Store existingStore);
}
