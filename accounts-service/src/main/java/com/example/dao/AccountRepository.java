package com.example.dao;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Repository layer of Account
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
