package com.acme.delivery.repository;

import com.acme.delivery.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

	Card findCardById(Long id);

	Card findCardByCardName(String name);
}
