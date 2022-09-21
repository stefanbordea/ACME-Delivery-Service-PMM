package com.acme.delivery.service;

import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import com.acme.delivery.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
	public List<Store> findByCategory(final StoreCategory category) {
		return storeRepository.findStoresByCategory(category);
	}

	@Override
	public Store findStoreById(final Long id) {
		return storeRepository.findStoreById(id);
	}

	@Override
	public void populateStoreObject(final Store convertedStore, final Store existingStore) {
		existingStore.setName(convertedStore.getName());
		existingStore.setPhoneNumber(convertedStore.getPhoneNumber());
		existingStore.setEmail(convertedStore.getEmail());
		existingStore.setOpenDays(convertedStore.getOpenDays());
		existingStore.setCategory(convertedStore.getCategory());
		existingStore.setAddress(convertedStore.getAddress());
		existingStore.setProductsMenu(convertedStore.getProductsMenu());
		storeRepository.save(existingStore);
	}

	@Override
	public List<Map<Integer, String>> mostFamousStores() {
		return storeRepository.mostFamousStores();
	}

	@Override
	public List<Map<Integer, Integer>> mostFamousStoresByCategory() {
		return storeRepository.mostFamousStoresByCategory();
	}
}
