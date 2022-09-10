package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Order(4)
@Component
@Profile("generate-stores")
@RequiredArgsConstructor
public class StoreSampleContentCreator extends BaseComponent implements CommandLineRunner {

	private final StoreService storeService;

	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {

		Set<Product> productsForFirstStore = new HashSet<>();
		productsForFirstStore.add(productService.findBySerial("S199999999"));
		productsForFirstStore.add(productService.findBySerial("B1123006700"));
		productsForFirstStore.add(productService.findBySerial("D112389900"));

		Set<Product> productsForSecondStore = new HashSet<>();
		productsForSecondStore.add(productService.findBySerial("Y1002389934"));

		List<Store> stores = List.of(Store.builder()
											 .name("Goody's")
											 .phoneNumber("2102525095")
											 .email("info@goodys.com")
											 .category(StoreCategory.BURGER_HOUSE)
											 .address(Address.builder()
															  .street("28hs Oktovriou")
															  .streetNumber("58")
															  .zipCode("10434")
															  .region("Athens")
															 .build())
											 .productsMenu(productsForFirstStore).build(),

									 Store.builder()
										  .name("Coffee island")
										  .phoneNumber("2130439351")
										  .email("info@coffeeisland.com")
										  .category(StoreCategory.COFFEE_SHOP)
										  .address(Address.builder()
														  .street("El Alamein")
														  .streetNumber("40")
														  .zipCode("14231")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForSecondStore).build());

		stores.forEach(storeService::create);

	}
}
