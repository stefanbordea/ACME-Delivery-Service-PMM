package com.acme.delivery.service;

import com.acme.delivery.domain.Product;
import com.acme.delivery.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public JpaRepository<Product, Long> getRepository() {
		return productRepository;
	}

	@Override
	public Product findBySerial(final String serial) {
		return productRepository.findBySerial(serial);
	}

	@Override
	public Product findByName(final String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Map<Integer, String>> tenMostFamousProducts() {
		return productRepository.tenMostFamousProducts();
	}
}

