package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    List<MovieCinema> findAll();

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinema_Id(Long cinemaId);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovie_Id(Long movieId);

    //Write a derived query to list all movie cinemas with higher than a specific date
//    List<MovieCinema> findByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovie_Name(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("select m from MovieCinema  m where m.dateTime > ?1")
    List<MovieCinema> retrieveCinemasAfterDate(LocalDate dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count (c.id) from movie_cinema c ",nativeQuery = true)
    Integer countByCinema_Id();

    //Write a native query that returns all movie cinemas by location name

    @Query(value = "select m.cinema.location.name from MovieCinema m ")
    List<String> retrieveMovieCinemasByLocationName();

}
