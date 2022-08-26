package com.acme.delivery.service;

import com.acme.delivery.domain.Product;

public interface ProductService extends BaseService<Product> {
	Product findBySerial(String serial);

	Product findByName(String name);
}
