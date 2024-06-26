package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer duration;
    private String name;
    private BigDecimal price;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    @Column(columnDefinition = "text") // if we put text it means there is no limit to write. not varchar(255)
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

//    @OneToMany(mappedBy = "movie")
//    private List<MovieCinema> movieCinema;




    public Movie(Integer duration, String name, BigDecimal price, LocalDate releaseDate, MovieState state, String summary, MovieType type) {
        this.duration = duration;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.state = state;
        this.summary = summary;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", state=" + state +
                ", summary='" + summary + '\'' +
                '}';
    }
}
