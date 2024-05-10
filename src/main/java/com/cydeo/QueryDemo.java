package com.cydeo;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final UserRepository userRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, UserRepository userRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.userRepository = userRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
    }


    @Override
    public void run(String... args) throws Exception{

        System.out.println("====================Account=====================");
        System.out.println(accountRepository.findByCountryOrState("United States", "Kentucky").get(0).getUser());
        System.out.println(accountRepository.findByAgeLessThanEqual(30));
        System.out.println(userRepository.findByEmail("bernard@email.com"));
        System.out.println("findByAgeBetween: "+accountRepository.findByAgeBetween(28,47));
        System.out.println("findByOrderByAgeDesc: "+accountRepository.findByOrderByAgeDesc());
        System.out.println("retrieveAllAccounts: "+accountRepository.retrieveAllAccounts());
        System.out.println("retrieveAdminAccounts: "+accountRepository.retrieveAdminAccounts(UserRole.ADMIN));
        System.out.println("retrieveSortedAccountByAge: "+accountRepository.retrieveSortedAccountByAge());
        System.out.println("retrieveAccountAgeLowerThan: "+accountRepository.retrieveAccountAgeLowerThan(35));
        System.out.println("retrieveAccountByValue: "+accountRepository.retrieveAccountByValue("ted"));
        System.out.println("retrieveAccountByAgeHigherThan: "+accountRepository.retrieveAccountByAgeHigherThan(35));





        System.out.println("====================Cinema=====================");
        System.out.println("findByName: "+cinemaRepository.findByName("Hall 4 - EMPIRE"));
        System.out.println("findTop3BySponsoredName: "+cinemaRepository.findTop3BySponsoredName("PlayStation"));
        System.out.println("findByLocationCountry: "+cinemaRepository.findByLocation_Country("United States"));
        System.out.println("findByNameOrSponsoredName: "+cinemaRepository.findByNameOrSponsoredName("Hall 1 - EMPIRE","McDonald"));
        System.out.println("retrieveCinemaById: "+cinemaRepository.retrieveCinemaById(1L));
        System.out.println("retrieveCinemaByCountry: "+cinemaRepository.retrieveCinemaByCountry("United States"));
        System.out.println("retrieveCinemaContainAPattern: "+cinemaRepository.retrieveCinemaContainAPattern("Mc"));
        System.out.println("sortCinemasByName: "+cinemaRepository.sortCinemasByName());
        System.out.println("distinctCinemaBySponsoredName: "+cinemaRepository.sortCinemasByName());




        System.out.println("====================Genre=====================");
        System.out.println("retrieveAllGenre: "+genreRepository.retrieveAllGenre());
        System.out.println("retrieveGenreByName: "+genreRepository.retrieveGenreByName());

        System.out.println("====================MovieCinema=====================");
//        System.out.println("findAll: "+movieCinemaRepository.findAll());
        System.out.println("findTop3ByMovie_Price: "+ movieCinemaRepository.findTop3ByOrderByMovie_PriceDesc());
        System.out.println("countByCinema_Id: "+movieCinemaRepository.countByCinema_Id(1L));
        System.out.println("countByMovie_Id: "+movieCinemaRepository.countByMovie_Id(5L));
//        System.out.println("findByDateTimeAfter: "+movieCinemaRepository.findByDateTimeAfter(LocalDateTime.of());
        System.out.println("findByMovie_Name: "+movieCinemaRepository.findByMovie_Name("The Gentleman"));
        System.out.println("findByCinema_Location_Name: "+movieCinemaRepository.findByCinema_Location_Name("AMC Empire 25"));
//        System.out.println("retrieveCinemasAfterDate: "+movieCinemaRepository.retrieveCinemasAfterDate(LocalDate.of(2020,12,6)));
        System.out.println("countByCinema_Id: "+movieCinemaRepository.countByCinema_Id());
        System.out.println("retrieveMovieCinemasByLocationName: "+movieCinemaRepository.retrieveMovieCinemasByLocationName());



        System.out.println("====================Movie=====================");
        System.out.println("findByName: "+movieRepository.findByName("The Gentleman"));
        System.out.println("findByPriceBetween: "+movieRepository.findByPriceBetween(15,48));
        System.out.println("findByDuration: "+movieRepository.findByDurationIn(Arrays.asList(100,113,181)));
        System.out.println("findByStateAndType: "+movieRepository.findByStateAndType(MovieState.ACTIVE, MovieType.REGULAR));
        System.out.println("retrieveMoviesBetweenPrices: "+movieRepository.retrieveMoviesBetweenPrices(BigDecimal.valueOf(10),BigDecimal.valueOf(35)));
        System.out.println("retrieveMovieNames: "+movieRepository.retrieveMovieNames());
        System.out.println("retrieveMovieName: "+movieRepository.retrieveMovieName("Tenet"));
        System.out.println("retrieveMoviesByPricesBetween: "+movieRepository.retrieveMoviesBetweenPrices(BigDecimal.valueOf(20),BigDecimal.valueOf(35)));
        System.out.println("retrieveMoviesByRangeOfDuration: "+movieRepository.retrieveMoviesByRangeOfDuration(100,150));
        System.out.println("retrieveTop5ExpensiveMovie: "+movieRepository.retrieveTop5ExpensiveMovie());


        System.out.println("====================Ticket=====================");
        System.out.println("countTicketByUserAccount: "+ticketRepository.countTicketByUserAccount_Id(2L));
        System.out.println("findByUserAccount_Email: "+ticketRepository.findByUserAccount_Email("josie_story@email.com"));
        System.out.println("countTicketByMovieCinema_Movie: "+ticketRepository.countTicketByMovieCinema_Movie_Name("The Gentleman"));
        System.out.println("retrieveTicketsBoughtByUser: "+ticketRepository.retrieveTicketsBoughtByUser(2L));
        System.out.println("retrieveCountOfTicketsUserBought: "+ticketRepository.retrieveCountOfTicketsUserBought(3L));
//        System.out.println("retrieveDistinctMovieByName: "+ticketRepository.retrieveDistinctMovieByName("The Gentleman"));
        System.out.println("retrieveTicketsByEmail: "+ticketRepository.retrieveTicketsByEmail("faith.p@email.com"));
        System.out.println("retrieveAllTickets: "+ticketRepository.retrieveAllTickets());
//        System.out.println("retrieveTicketsByUsernameOrAccountNameOrMovieName: "+ticketRepository.retrieveTicketsByUsernameOrAccountNameOrMovieName("The Loss Adjuster"));

        System.out.println("====================User=====================");
        System.out.println("findByEmail: "+userRepository.findByEmail("josie_story@email.com"));
        System.out.println("findByUsername: "+userRepository.findByUsername("bernard"));
        System.out.println("findByAccount_Name: "+userRepository.findByAccount_Name("Josie D Story"));
        System.out.println("findUsersByAccountContainingIgnoreCaseAndAccount_Name: "+userRepository.findByAccountNameEqualsIgnoreCase("bernard p fendley"));
        System.out.println("findByAccount_AgeGreaterThan: "+userRepository.findByAccount_AgeGreaterThan(30));
        System.out.println("retrieveUserByEmail: "+userRepository.retrieveUserByEmail("johnnie@email.com"));
        System.out.println("retrieveUserByUsername: "+userRepository.retrieveUserByUsername("lawrence.f"));
        System.out.println("retrieveAllUsers: "+userRepository.retrieveAllUsers());
        System.out.println("retrieveUserBySpecificName: "+userRepository.retrieveUserBySpecificName("Faith R Parsons"));
        System.out.println("retrieveAllUser: "+userRepository.retrieveAllUser());
        System.out.println("retrieveUserBetweenAge: "+userRepository.retrieveUserBetweenAge(28,47));
        System.out.println("retrieveAUserByEmail: "+userRepository.retrieveAUserByEmail("bernard@email.com"));



    }
}
