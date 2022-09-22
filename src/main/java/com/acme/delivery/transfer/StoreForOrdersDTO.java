package com.acme.delivery.transfer;

import com.acme.delivery.domain.Address;
import lombok.Data;

@Data
public class StoreForOrdersDTO {
	private String name;
	private Address address;
}
