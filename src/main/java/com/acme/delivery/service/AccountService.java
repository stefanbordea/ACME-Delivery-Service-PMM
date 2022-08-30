package com.acme.delivery.service;

import com.acme.delivery.domain.Account;

public interface AccountService extends BaseService<Account>{

	Account findByEmail(String email);

	Account findByPhoneNumber(String phoneNumber);

}
