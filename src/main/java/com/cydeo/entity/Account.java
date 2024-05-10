package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account_details")
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                ", state='" + state + '\'' +
                '}';
    }
}
