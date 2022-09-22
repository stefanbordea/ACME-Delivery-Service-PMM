package com.acme.delivery.controller;

import com.acme.delivery.converter.AccountConverter;
import com.acme.delivery.converter.PastOrdersConverter;
import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Card;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.BaseService;
import com.acme.delivery.service.CardService;
import com.acme.delivery.service.OrderService;
import com.acme.delivery.transfer.AccountDTO;
import com.acme.delivery.transfer.ApiResponse;
import com.acme.delivery.transfer.PastOrdersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("accounts")
@CrossOrigin
public class AccountController extends BaseController<Account>{

	private final AccountService accountService;
	private final OrderService orderService;
	private final AccountConverter accountConverter;
	private final CardService cardService;
	private final PastOrdersConverter pastOrdersConverter;
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
	public ResponseEntity<ApiResponse<Account>> findByPhoneNumber(@Valid @RequestParam String phoneNumber){
		final Account accountByPhoneNumber = accountService.findByPhoneNumber(phoneNumber);
		if(accountByPhoneNumber == null){
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<Account>builder().data(accountByPhoneNumber).build());
	}

	@GetMapping(value = "pastOrders", params = "email")
	public ResponseEntity<ApiResponse<List<PastOrdersDTO>>> findPastOrders(@Email @RequestParam String email) {
		final List<PastOrdersDTO> pastOrdersDTO = pastOrdersConverter.entityToDto(orderService.findOrdersByAccount_Email(email));
		if(email == null){
			throw new NoSuchElementException("Element not found");
		}
		return ResponseEntity.ok(ApiResponse.<List<PastOrdersDTO>>builder().data(pastOrdersDTO).build());
	}

	@PostMapping(value = "addAddress", params = "email")
	public ResponseEntity<ApiResponse<Account>> addAddressToAccount(@Email @RequestParam String email,
																			  @RequestBody Address address){
		final Account accountToBeUpdated = accountService.findByEmail(email);
		accountService.addAddressToAccount(accountToBeUpdated, address, email);
		if (accountToBeUpdated == null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
									HttpStatus.CREATED);
	}

	@PostMapping(value = "addCard", params = "email")
	public ResponseEntity<ApiResponse<Card>> addCardToAccount (@Email @RequestParam String email,
															   @RequestBody Card card){
		final Card addedCard = cardService.create(card);
	cardService.addCardToAccount(addedCard, email);
		if (addedCard == null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Card>builder().data(addedCard).build(),
									HttpStatus.CREATED);
	}

	@PostMapping( "create")
	public ResponseEntity<ApiResponse<Account>> createAccount(@RequestBody AccountDTO account){
			final Account createNewAccount = accountConverter.dtoToEntity(account);
			accountService.create(createNewAccount);
		if (account == null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(createNewAccount).build(), HttpStatus.CREATED);
		}

	@PatchMapping(value = "updateEmail/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<Account>> updateEmail(@Email @PathVariable String email,
																   @RequestBody Map<String, String> data){
	    final Account accountToBeUpdated = accountService.findByEmail(email);
		accountService.updateEmail(accountToBeUpdated, data.get("email"));
			if (email == null) {
				throw new NoSuchElementException("Missing elements in account");
			}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
									HttpStatus.NO_CONTENT);
		}

	@PatchMapping(value = "updatePassword/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<Account>> updatePassword(@Valid @Email @PathVariable(value = "email") String email,
															   @Valid @RequestBody Map<String, String> data) {
		final Account accountToBeUpdated = accountService.findByEmail(email);
		accountService.updatePassword(accountToBeUpdated, data.get("password"));
		if (email== null && data.get("password")==null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
									HttpStatus.NO_CONTENT);
		}

	@PatchMapping(value = "updatePhoneNumber/{email}" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse<Account>> updatePhoneNumber(@Email @PathVariable(value = "email") String email,
																  @RequestBody Map<String, String> data)
	{
		final Account accountToBeUpdated = accountService.findByEmail(email);
		accountService.updatePhoneNumber(accountToBeUpdated, data.get("phoneNumber"));
		if (email== null && data.get("phoneNumber")==null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
									HttpStatus.NO_CONTENT);
	}


	@ResponseStatus (HttpStatus.NO_CONTENT)
	@DeleteMapping(params = "email")
	void deleteAccountByEmail(@Email @RequestParam String email){
		if (email == null) {
			throw new NoSuchElementException("Missing elements in account");
		}
		accountService.deleteAccountByEmail(email);
	}


	//	@PutMapping("update/{email}")
	//		public ResponseEntity<ApiResponse<Account>>  updateAccount(@Email @PathVariable(value = "email") String email,
	//																   @RequestBody Account updatedAccount){
	//			final Account accountToBeUpdated = accountService.findByEmail(email);
	//
	//			accountToBeUpdated.setEmail(updatedAccount.getEmail());
	//			accountToBeUpdated.setPassword(updatedAccount.getPassword());
	//			accountToBeUpdated.setPhoneNumber(updatedAccount.getPhoneNumber());
	//			accountToBeUpdated.setAddresses(new HashSet<Address>(updatedAccount.getAddresses()));
	//			accountToBeUpdated.setSavedCards(new HashSet<Card>(updatedAccount.getSavedCards()));
	//			accountService.update(accountToBeUpdated);
	//
	//			return new ResponseEntity<>(ApiResponse.<Account>builder().data(accountToBeUpdated).build(),
	//										HttpStatus.NO_CONTENT);
	//		}
}
