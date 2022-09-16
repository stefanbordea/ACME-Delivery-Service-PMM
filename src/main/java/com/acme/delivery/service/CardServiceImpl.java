package com.acme.delivery.service;

import com.acme.delivery.domain.Card;
import com.acme.delivery.repository.AccountRepository;
import com.acme.delivery.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl extends BaseServiceImpl<Card> implements CardService {

	private final CardRepository cardRepository;
	private final AccountService accountService;
	@Override
	public JpaRepository<Card, Long> getRepository() {
		return cardRepository;
	}

	@Override
	public Card findById(final Long id) {
		return cardRepository.findCardById(id);
	}

	@Override
	public Card findByCardName(final String name) {
		return cardRepository.findCardByCardName(name);
	}

	@Override
	public Card addCardToAccount(final Card addedCard, final String email) {
		addedCard.setAccount(accountService.findByEmail(email));
		return cardRepository.save(addedCard);


	}

}
