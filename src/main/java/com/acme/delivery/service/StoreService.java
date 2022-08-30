package com.acme.delivery.service;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;

public interface StoreService extends BaseService<Store> {

	Store findByName(String name);

	Store findByCategory(StoreCategory[] categories);
}
