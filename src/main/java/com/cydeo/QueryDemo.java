package com.cydeo;

import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public QueryDemo(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception{

        System.out.println("====================Account=====================");
//        System.out.println(accountRepository.findByCountryOrState("United States", "Kentucky").get(0).getUser());
//        System.out.println(accountRepository.findByAgeLessThanEqual(30));
        System.out.println(userRepository.findByEmail("bernard@email.com"));


    }
}
