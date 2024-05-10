package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    List<User> findByEmail(String email);

    //Write a derived query to read a user with a username?
    List<User> findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> findByAccount_Name(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> findByAccountNameEqualsIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findByAccount_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email=?1")
    List<User> retrieveUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    List<User> retrieveUserByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> retrieveAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT u.* FROM user_account u JOIN account_details a ON u.account_details_id = a.id WHERE a.name = ?1", nativeQuery = true)
    List<User> retrieveUserBySpecificName(String name);
    //Write a native query that returns all users?
    @Query(value = "select u.* from user_account u",nativeQuery = true)
    List<User> retrieveAllUser();
    //Write a native query that returns all users in the range of ages?
    @Query(value = "select u.* from user_account u join account_details a on u.account_details_id=a.id where a.age between ?1 and ?2",nativeQuery = true)
    List<User> retrieveUserBetweenAge(int age1,int age2);
    //Write a native query to read a user by email?

    @Query(value = "select c.* from user_account c where c.email=?1",nativeQuery = true)
    User retrieveAUserByEmail(String email);


}
