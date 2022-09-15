package com.acme.delivery.transfer;

import lombok.Data;

@Data
public class AccountDTO {
	private String email;
	private String password;
	private String phoneNumber;
}
