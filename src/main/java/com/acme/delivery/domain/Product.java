package com.acme.delivery.domain;

import java.math.BigDecimal;
import java.util.Set;

public class Product extends BaseModel {

	private String serial;
	private String name;
	private String description;
	private BigDecimal price;
	private Set<ProductCategory> categories;
}
