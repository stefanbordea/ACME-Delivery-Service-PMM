package com.acme.delivery.repository;

import com.acme.delivery.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByEmail(String email);

	Account findByPhoneNumber(String phoneNumber);

	void deleteAccountByEmail(String email);


}
