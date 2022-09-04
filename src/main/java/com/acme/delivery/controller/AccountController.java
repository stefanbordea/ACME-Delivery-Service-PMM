package com.acme.delivery.controller;

import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Card;
import com.acme.delivery.domain.Product;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.HashSet;
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

	@GetMapping(params = "phoneNumber")
	public ResponseEntity<ApiResponse<Account>> findByPhoneNumber(@RequestParam String phoneNumber){
		final Account accountByPhoneNumber = accountService.findByPhoneNumber(phoneNumber);

		if(accountByPhoneNumber == null){
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<Account>builder().data(accountByPhoneNumber).build());
	}

	@PostMapping( "create")
		public ResponseEntity<ApiResponse<Account>> createAccount(@RequestBody Account account){
			final Account createNewAccount = accountService.create(account);

		if (account == null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(createNewAccount).build(), HttpStatus.CREATED);
		}

	@PutMapping("update/{email}")
		public ResponseEntity<ApiResponse<Account>>  updateAccount(@Email @PathVariable(value = "email") String email,
																   @RequestBody Account updatedAccount){
			final Account accountToBeUpdated = accountService.findByEmail(email);

			accountToBeUpdated.setEmail(updatedAccount.getEmail());
			accountToBeUpdated.setPassword(updatedAccount.getPassword());
			accountToBeUpdated.setPhoneNumber(updatedAccount.getPhoneNumber());
//			accountToBeUpdated.setAddresses(new HashSet<Address>(updatedAccount.getAddresses()));
//			accountToBeUpdated.setSavedCards(new HashSet<Card>(updatedAccount.getSavedCards()));
			accountService.update(accountToBeUpdated);

			return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
										HttpStatus.NO_CONTENT);
		}

	@DeleteMapping(params = "email")
	void deleteAccountByEmail(@Email @RequestParam String email){
		accountService.deleteAccountByEmail(email);
	}

}
