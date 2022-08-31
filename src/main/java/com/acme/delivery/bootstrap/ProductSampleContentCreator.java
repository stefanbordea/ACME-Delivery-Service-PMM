package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.ProductCategory;
import com.acme.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("generate-products")
@RequiredArgsConstructor
public class ProductSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		List<Product> products = List.of(Product.builder().serial("S199999999").name("The Big Bad Wolf").description(
														"Lorem Ipsum is simply dummy text of the printing and t industry").price(BigDecimal.valueOf(3.70))
												.categories(ProductCategory.SOUVLAKI).build(), Product.builder().serial(
				"B1123006700").name("Goody's Burger House").description(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry").price(
				BigDecimal.valueOf(4.60)).categories(ProductCategory.BURGER).build(), Product.builder().serial(
				"D112389900").name("Caesar`s").description(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry").price(
				BigDecimal.valueOf(5.60)).categories(ProductCategory.SALADS).build(), Product.builder().serial(
				"L1012309900").name("Chicken mayo parmesan burge").description(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry").price(
				BigDecimal.valueOf(5.60)).categories(ProductCategory.BURGER).build(), Product.builder().serial(
				"Z1002389910").name("Chicken mayo parmesan burge").description(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry").price(
				BigDecimal.valueOf(5.60)).categories(ProductCategory.BURGER).build(), Product.builder().serial(
				"Y1002389934").name("Red Bull Energy Drink 250ml").description(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry").price(
				BigDecimal.valueOf(1.60)).categories(ProductCategory.DRINKS).build());
		productService.createAll(products);
	}
}
