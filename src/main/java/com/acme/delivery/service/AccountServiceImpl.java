package com.acme.delivery.service;

import com.acme.delivery.domain.Account;
import com.acme.delivery.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{

	private final AccountRepository accountRepository;

	@Override
	public JpaRepository<Account, Long> getRepository() {
		return accountRepository;
	}

	@Override
	public Account findByEmail(final String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public Account findByPhoneNumber(final String phoneNumber) { return accountRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public void deleteAccountByEmail(final String email) {
		 accountRepository.deleteAccountByEmail(email);
	}

}
