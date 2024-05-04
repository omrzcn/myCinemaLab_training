package com.cydeo.entity;

import com.cydeo.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
public class AccountDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String address;
//    address, age, city, country, name, postal_code, role, state

    private String age;
    private String country;
    private String city;
    private String name;
    private String postalCode;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String state;

    @OneToOne(mappedBy = "accountDetails")
    private UserAccount userAccount;

    public AccountDetails(String address, String age,String city, String country,  String name, String postalCode, Role role, String state, UserAccount userAccount) {
        this.address = address;
        this.age = age;
        this.country = country;
        this.city = city;
        this.name = name;
        this.postalCode = postalCode;
        this.role = role;
        this.state = state;
        this.userAccount = userAccount;
    }
}
