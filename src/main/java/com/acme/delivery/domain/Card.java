package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARDS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CARDS_SEQ", allocationSize = 1)
public class Card extends BaseModel {

	@Column(length = 16, nullable = false)
	private Long cardNumber;
	@Column(length = 30, nullable = false)
	private String cardName;
	@Column(length = 5, nullable = false)
	private LocalDate cardExpirationDate;
	@Column(length = 3, nullable = false)
	private Integer cardSecurityCode;
}
