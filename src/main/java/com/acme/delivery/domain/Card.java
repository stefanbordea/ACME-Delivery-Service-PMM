package com.acme.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

//	@NotNull
	@ManyToOne
	@JsonIgnore
	private Account account;
	@Column(length = 16, nullable = false)
	@NotNull
	@Pattern(regexp = "^[0-9]{12,}(?:[0-9]{3})?$")
	private String cardNumber;
	@Column(length = 30, nullable = false)
	@NotNull
	@NotEmpty
	private String cardName;
	@Column(length = 5, nullable = false)
	@NotNull
	private LocalDate cardExpirationDate;
	@Column(length = 4, nullable = false)
	@NotNull
	@Pattern(regexp = "^[0-9]{3,4}$")
	private String cardSecurityCode;
}
