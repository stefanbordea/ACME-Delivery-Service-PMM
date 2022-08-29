package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNT", indexes = {@Index(name = "ACCOUNT_IDX_01", columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
public class Account extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
    private String email;
	@Column(length = 30, nullable = false)
    private String password;
	@Column(length = 30, nullable = false, unique = true)
    private String phoneNumber;
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Address> addresses;
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Card> savedCards;
	@OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Order> pastOrders;
}
