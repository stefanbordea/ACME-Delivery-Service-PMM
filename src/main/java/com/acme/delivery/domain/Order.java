package com.acme.delivery.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Order extends BaseModel {

    private Account customer;
    private Address deliveryAddress;
    private PaymentMethod paymentMethod;
    private String serial;
    private Date date;
    private BigDecimal totalPrice;
    private Set<OrderItem> orderItems;
}
