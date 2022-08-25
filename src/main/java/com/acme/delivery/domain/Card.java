package com.acme.delivery.domain;

import java.time.LocalDate;

public class Card extends BaseModel {

    private Long cardNumber;
    private String cardName;
    private LocalDate cardExpirationDate;
    private Integer cardSecurityCode;
}
