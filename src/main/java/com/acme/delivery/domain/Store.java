package com.acme.delivery.domain;

import java.time.DayOfWeek;
import java.util.Set;

public class Store extends BaseModel {

    private String name;
    private String phoneNumber;
    private String email;
    private Set<DayOfWeek> openDays;
    private Set<StoreCategory> categories;
    private Address address;
    private Set<Product> productsMenu;
}
