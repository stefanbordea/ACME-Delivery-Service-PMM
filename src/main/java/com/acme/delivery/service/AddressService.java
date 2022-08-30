package com.acme.delivery.service;

import com.acme.delivery.domain.Address;

public interface AddressService extends BaseService<Address>{
	Address findByStreet(String street);

	Address findByZipCode(String zipCode);

	Address findByStreetAndStreetNumber(String street, String streetNumber);
}
