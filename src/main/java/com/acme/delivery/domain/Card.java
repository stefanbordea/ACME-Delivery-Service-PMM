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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	@NotNull
	private Long cardNumber;
	@Column(length = 30, nullable = false)
	@NotNull
	@NotEmpty
	private String cardName;
	@Column(length = 5, nullable = false)
	@NotNull
	private LocalDate cardExpirationDate;
	@Column(length = 3, nullable = false)
	@NotNull
	private Integer cardSecurityCode;
}
