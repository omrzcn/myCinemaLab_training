package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Cinema findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredName(String sponsoredName);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name,String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c from Cinema  c where c.id=?1")
    Cinema retrieveCinemaById(Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "select c from Cinema c join Location l on c.location.id = l.id where c.location.country=:country")
    List<Cinema> retrieveCinemaByCountry(@Param("country") String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select c from Cinema  c where c.name like %:pattern% or c.sponsoredName like %:pattern%")
    List<Cinema> retrieveCinemaContainAPattern(@Param("pattern") String pattern);
    //Write a native query to sort all cinemas by name

    @Query(value = "select c.* from cinema c order by c.name asc",nativeQuery = true)
    List<Cinema> sortCinemasByName();

    //Write a native query to distinct all cinemas by sponsored name

    @Query(value = "select distinct c.* from cinema c",nativeQuery = true)
    List<Cinema> distinctCinemaBySponsoredName();


}
