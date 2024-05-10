package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    // ManyToMany is Fetch.LAZY, so we dont have to write anything
    // ManyToOne is Fetch.EAGER, so we can write Fetch.LAZY
    // OneToMany is Fetch.LAZY, so we dont wrote anything
    // OneToOne is Fetch.EAGER, so we can write Fetch.LAZY .......these are all about performance. Fetch.LAZY is good to use it.
    // FETCH is gonna be good to use in big datas.
    @ManyToOne(fetch = FetchType.LAZY) // it means that when we run the application its gonna fetch when we needed
    //FetchType.EAGER) it means when we run, it will fetch immediatly
    private Cinema cinema; // buraya ManyToOne yazdigimiz icin sinemada OneToMany yazmamiza gerek yok

    @ManyToOne(fetch = FetchType.LAZY) //
    private Movie movie; // bunu buraya yazdiysak, Movie sinifinda OneToMany yazmamiza gerek yok

//    @OneToMany(mappedBy = "movieCinema")
//    private List<Ticket> ticketList;  we put ManyToOne in Ticket class that's why we dont have to write OneToMany here.





    public MovieCinema(LocalDateTime dateTime, Cinema cinema, Movie movie) {
        this.dateTime = dateTime;
        this.cinema = cinema;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "MovieCinema{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                '}';
    }
}
