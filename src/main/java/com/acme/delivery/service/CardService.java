package com.acme.delivery.service;

import com.acme.delivery.domain.Card;

public interface CardService extends BaseService<Card> {

	Card findById(Long id);

	Card findByCardName(String name);
}
