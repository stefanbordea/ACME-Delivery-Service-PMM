package com.acme.delivery.controller;

import com.acme.delivery.converter.StoreConverter;
import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.StoreService;
import com.acme.delivery.transfer.ApiResponse;
import com.acme.delivery.transfer.StoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("stores")
public class StoreController extends BaseController<Store> {
	//TODO: exception handling and validation
	private final StoreService storeService;
	private final StoreConverter storeConverter;

	@Override
	protected BaseService<Store> getBaseService() {
		return storeService;
	}

	@GetMapping(params = "name")
	public ResponseEntity<ApiResponse<StoreDTO>> getStoreByName(@RequestParam String name) {
		final Store existingStore = storeService.findByName(name);
		if (existingStore == null) {
			throw new NoSuchElementException();
		}
		final StoreDTO storeByName = storeConverter.entityToDto(existingStore);
		return ResponseEntity.ok(ApiResponse.<StoreDTO>builder().data(storeByName).build());
	}

	@GetMapping(params = "category")
	public ResponseEntity<ApiResponse<List<StoreDTO>>> getStoresByCategory(@RequestParam StoreCategory category) {
		final List<StoreDTO> storesByCategory = storeConverter.entityToDto(storeService.findByCategory(category));
		return ResponseEntity.ok(ApiResponse.<List<StoreDTO>>builder().data(storesByCategory).build());
	}

	@PostMapping("create")
	public ResponseEntity<ApiResponse<Store>> createStore(@RequestBody StoreDTO store) {
		final Store storeToBeCreated = storeConverter.dtoToEntity(store);
		getBaseService().create(storeToBeCreated);
		return new ResponseEntity<>(ApiResponse.<Store>builder().data(storeToBeCreated).build(), HttpStatus.CREATED);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ApiResponse<Store>> updateStore(@RequestBody StoreDTO store, @PathVariable Long id) {
		final Store storeToBeUpdated = storeConverter.dtoToEntity(store);
		Store storeById = storeService.findStoreById(id);
		if (storeById == null) {
			throw new NoSuchElementException();
		}
		storeService.populateStoreObject(storeToBeUpdated, storeById);
		return new ResponseEntity<>(ApiResponse.<Store>builder().data(storeById).build(), HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<ApiResponse<Store>> deleteStoreById(@PathVariable Long id) {
		storeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
