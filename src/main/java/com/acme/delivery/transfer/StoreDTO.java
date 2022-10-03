package com.acme.delivery.transfer;

import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.StoreCategory;
import lombok.Data;

import java.util.Set;

@Data
public class StoreDTO {
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String openDays;
	private StoreCategory category;
	private Address address;
	private Set<Product> productsMenu;
}
