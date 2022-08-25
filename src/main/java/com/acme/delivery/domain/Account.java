package com.acme.delivery.domain;

import java.util.Set;

public class Account extends BaseModel {

    private String email;
    private String password;
    private String phoneNumber;
    private Set<Address> addresses;
    private Set<Card> savedCards;
    private Set<Order> pastOrders;
}
