package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {

	private final AddressRepository addressRepository;

	@Override
	public JpaRepository<Address, Long> getRepository() {
		return addressRepository;
	}

	@Override
	public Address findByStreet(String street) {
		return addressRepository.findByStreet(street);
	}

	@Override
	public Address findByZipCode(final String zipCode) {
		return addressRepository.findByZipCode(zipCode);
	}

	@Override
	public Address findByStreetAndStreetNumber(final String street, final String streetNumber) {
		return addressRepository.findByStreetAndStreetNumber(street, streetNumber);
	}

}
