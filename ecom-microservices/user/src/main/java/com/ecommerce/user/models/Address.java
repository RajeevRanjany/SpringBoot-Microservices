package com.ecommerce.user.models;


import lombok.Data;

@Data
public class Address {
/*
this will part of user table, and we don't need to create one like we used to do in postgres
 */
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

}

/*

// connection for JPA repository


package com.ecommerce.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;

}


 */
