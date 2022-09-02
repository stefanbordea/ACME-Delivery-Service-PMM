package com.acme.delivery.controller;

import com.acme.delivery.domain.Account;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
public class AccountController extends BaseController<Account>{

	private final AccountService accountService;
	@Override
	protected BaseService<Account> getBaseService() {
		return accountService;
	}

	@GetMapping(params = "email")
	public ResponseEntity<ApiResponse<Account>> findByEmail(@Email @RequestParam String email){
		final Account accountByEmail = accountService.findByEmail(email);

		if(accountByEmail == null){
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<Account>builder().data(accountByEmail).build());
	}
}
