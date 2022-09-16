package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;

public interface AccountService extends BaseService<Account>{

	Account findByEmail(String email);

	Account findByPhoneNumber(String phoneNumber);

	void deleteAccountByEmail(String email);

	Account updateEmail(Account accountToBeUpdated, String email);
	Account updatePhoneNumber (Account accountToBeUpdated, String phoneNumber);
	Account updatePassword (Account accountToBeUpdated, String password);
	Account addAddressToAccount(Account accountToBeUpdated,Address address, String email);

}
