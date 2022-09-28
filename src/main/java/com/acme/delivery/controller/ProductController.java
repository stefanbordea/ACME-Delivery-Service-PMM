package com.acme.delivery.controller;


import com.acme.delivery.domain.Product;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController extends BaseController<Product> {
	private final ProductService productService;

	@Override
	protected BaseService<Product> getBaseService() {
		return productService;
	}

	@GetMapping(params = "name")
	public ResponseEntity<ApiResponse<Product>> findByName(@RequestParam Optional<String> name) {
		final Product productByName = productService.findByName(String.valueOf(name));

		if (productByName == null) {
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<Product>builder().data(productByName).build());
	}

	@GetMapping(params = "serial")
	public ResponseEntity<ApiResponse<Product>> findBySerial(@RequestParam String serial) {
		final Product productBySerial = productService.findBySerial(serial);

		if (productBySerial == null) {
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<Product>builder().data(productBySerial).build());
	}

	@GetMapping("mostFamous")
	public ResponseEntity<ApiResponse<List<Map<Integer, String>>>> findMostFamousProducts() {

		final List<Map<Integer, String>> mostFamousProducts = productService.tenMostFamousProducts();

		if( mostFamousProducts == null){
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<List<Map<Integer, String>>>builder().data(mostFamousProducts).build());
	}

	@PostMapping("create")
	public ResponseEntity<ApiResponse<Product>> createProduct(@Valid @RequestBody Product product) {
		final Product createdProduct = productService.create(product);
		if (product == null) {
			throw new NoSuchElementException();
		}
		return new ResponseEntity<>(ApiResponse.<Product>builder().data(createdProduct).build(), HttpStatus.CREATED);
	}

	@PutMapping("update/{serial}")
	public ResponseEntity<ApiResponse<Product>> updateProduct(@PathVariable(value = "serial") String productSerial,
															  @Valid @RequestBody Product updatedProduct) {
		Product productToBeUpdated = productService.findBySerial(productSerial);
		if (productToBeUpdated == null) {
			throw new NoSuchElementException();
		}
		productToBeUpdated.setName(updatedProduct.getName());
		productToBeUpdated.setDescription(updatedProduct.getDescription());
		productToBeUpdated.setPrice(updatedProduct.getPrice());
		productToBeUpdated.setCategories(updatedProduct.getCategories());
		productService.update(productToBeUpdated);

		return new ResponseEntity<>(ApiResponse.<Product>builder().data(productToBeUpdated).build(),
									HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("delete/{serial}")
	public ResponseEntity<ApiResponse<Product>> deleteProduct(@PathVariable String serial) {
		final Product productToBeDeleted = productService.findBySerial(serial);
		if (productToBeDeleted == null) {
			throw new NoSuchElementException();
		}
		productService.delete(productToBeDeleted);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
