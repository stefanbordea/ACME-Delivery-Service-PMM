package com.acme.delivery.service;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import com.acme.delivery.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl extends BaseServiceImpl<Store> implements StoreService {

	private final StoreRepository storeRepository;

	@Override
	public JpaRepository<Store, Long> getRepository() {
		return storeRepository;
	}

	@Override
	public Store findByName(final String name) {
		return storeRepository.findByName(name);
	}

	@Override
	public Store findByCategory(final Set<StoreCategory> categories) {
		return storeRepository.findStoreByCategories(categories);
	}
}
