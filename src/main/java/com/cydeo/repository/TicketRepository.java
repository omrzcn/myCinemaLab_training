package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countTicketByUserAccount_Id(Long id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countTicketByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id=?1")
    List<Ticket> retrieveTicketsBoughtByUser(Long id);

    //Write a JPQL query that returns all tickets between a range of dates


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select count (*) from ticket  where user_account_id=?1 ",nativeQuery = true)
    Integer retrieveCountOfTicketsUserBought(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates


    //Write a native query to distinct all tickets by movie name

    //Write a native query to find all tickets by user email
//    @Query("select t from Ticket t where t.userAccount.email=?1")
    @Query(value = "select t.* from ticket t join user_account u on t.user_account_id=u.id where u.email=?1",nativeQuery = true)
    List<Ticket> retrieveTicketsByEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "select t.* from ticket t ",nativeQuery = true)
    List<Ticket> retrieveAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
     @Query(value = "select t.* from ticket t join movie m on t.movie_cinema_id=m.id join user_account u on t.user_account_id=u.account_details_id join account_details a on a.id = u.id where a.name=?1 or u.username=?1 or m.name=?1",nativeQuery = true)
    List<Ticket> retrieveTicketsByUsernameOrAccountNameOrMovieName(String name);

}
