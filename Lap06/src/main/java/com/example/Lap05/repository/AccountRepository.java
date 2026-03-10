package com.example.Lap05.repository;

import com.example.Lap05.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("SELECT a FROM Account a WHERE a.login_username = :login_username")
    Optional<Account> findByLoginName(@Param("login_username") String login_username);
}
