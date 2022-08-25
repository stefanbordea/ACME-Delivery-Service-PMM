package com.acme.delivery.domain;

import java.math.BigDecimal;

public class OrderItem extends BaseModel {

    private Integer quantity;
    private BigDecimal price;
    private Product product;
    private Order order;

}
