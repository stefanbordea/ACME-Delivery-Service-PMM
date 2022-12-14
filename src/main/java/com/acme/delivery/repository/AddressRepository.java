package com.acme.delivery.repository;

import com.acme.delivery.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Address findByStreet(String street);

	Address findByZipCode(String zipCode);

	Address findByStreetAndStreetNumber(String street, String streetNumber);

}
