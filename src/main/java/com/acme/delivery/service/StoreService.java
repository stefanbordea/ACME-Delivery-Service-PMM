package com.acme.delivery.service;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;

import java.util.Set;

public interface StoreService extends BaseService<Store> {

	Store findByName(String name);

	Store findByCategory(Set<StoreCategory> categories);
}
