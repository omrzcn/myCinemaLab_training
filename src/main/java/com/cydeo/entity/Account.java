package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String address;
//    address, age, city, country, name, postal_code, role, state

    private Integer age;
    private String country;
    private String city;
    private String name;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    private String state;

    @OneToOne(mappedBy = "account")
    private User user;


}
