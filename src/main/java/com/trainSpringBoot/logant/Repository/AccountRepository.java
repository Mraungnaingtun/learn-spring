package com.trainSpringBoot.logant.Repository;


import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.Base.MyBaseRepository;
import com.trainSpringBoot.logant.Entity.Account;

@Repository
public interface AccountRepository extends MyBaseRepository<Account, Long> {
}