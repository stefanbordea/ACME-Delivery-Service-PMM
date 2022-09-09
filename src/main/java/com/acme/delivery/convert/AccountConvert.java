package com.acme.delivery.convert;

import com.acme.delivery.domain.Account;
import com.acme.delivery.transfer.AccountOrdersDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AccountConvert {
	private final ModelMapper mapper;

	public Account dtoToEntity(AccountOrdersDto accountOrdersDto) {

		Account account = mapper.map(accountOrdersDto, Account.class);
		return account;
	}

	public AccountOrdersDto entityToDto(Account account) {

		ModelMapper mapper = new ModelMapper();
		AccountOrdersDto map = mapper.map(account, AccountOrdersDto.class);
		return map;
	}

	public List<AccountOrdersDto> entityToDto(List<Account> accounts) {

		return accounts.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

}
