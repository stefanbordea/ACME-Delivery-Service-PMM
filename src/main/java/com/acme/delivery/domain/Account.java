package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(name = "ACCOUNTS_IDX_01", columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", allocationSize = 1)
public class Account extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	@Email
    private String email;
	@Column(length = 30, nullable = false)
	@NotNull
	@NotEmpty
    private String password;
	@Column(length = 30, nullable = false, unique = true)
	@NotEmpty
	@NotNull
    private String phoneNumber;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Address> addresses;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Card> savedCards;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> pastOrders;
}
