package com.acme.delivery.service;

import com.acme.delivery.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService extends BaseService<Product> {
	Product findBySerial(String serial);

	Product findByName(String name);
	List<Map<Integer, String>> tenMostFamousProducts();
}
