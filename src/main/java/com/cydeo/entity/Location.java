package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String postalCode;
    private String country;
    private String state;
    private String city;

//    @OneToMany(mappedBy = "location")
//    private List<Cinema> cinemaList;  // we dont have to write this because we used ManyToOne in Cinema class


    public Location(String name, BigDecimal latitude, BigDecimal longitude, String address, String postalCode, String country, String state, String city) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;
        this.state = state;
        this.city = city;
    }
}
