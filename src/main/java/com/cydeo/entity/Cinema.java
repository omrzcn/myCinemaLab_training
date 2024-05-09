package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sponsoredName;


    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

//    @OneToMany(mappedBy = "cinema")
//    private List<MovieCinema> movieCinemaList;

    public Cinema(String name, String sponsoredName, Location location) {
        this.name = name;
        this.sponsoredName = sponsoredName;
        this.location = location;
    }
}
