package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer duration;
    private String name;
    private BigDecimal price;
    private LocalDate releaseDate;
    @Enumerated(EnumType.STRING)
    private State state;
    private String summary;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany(mappedBy = "movieList")
    private List<Genre> genreList;

    @OneToMany(mappedBy = "movie")
    private List<MovieCinema> movieCinema;




    public Movie(Integer duration, String name, BigDecimal price, LocalDate releaseDate, State state, String summary, Type type) {
        this.duration = duration;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.state = state;
        this.summary = summary;
        this.type = type;
    }
}
