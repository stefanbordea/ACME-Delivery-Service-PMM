package com.acme.delivery.converter;

import com.acme.delivery.domain.Account;
import com.acme.delivery.transfer.AccountDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AccountConverter {
	private final ModelMapper mapper;

	public Account dtoToEntity(AccountDTO accountDTO) {

		Account account = mapper.map(accountDTO, Account.class);
		return account;
	}

	public AccountDTO entityToDto(Account account) {

		AccountDTO map = mapper.map(account, AccountDTO.class);
		return map;
	}

	public List<AccountDTO> entityToDto(List<Account> accounts) {

		return accounts.stream().map(this::entityToDto).toList();
	}

}
