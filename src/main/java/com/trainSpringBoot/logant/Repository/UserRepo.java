package com.trainSpringBoot.logant.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.scheduling.annotation.Async;

import com.trainSpringBoot.logant.Entity.User;
import com.trainSpringBoot.logant.Projections.UserSummary;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public interface UserRepo extends MongoRepository<User, String> {


    List<User> findByPassword(String password);

    UserSummary findByEmailAndPassword(String email, String password);

    Streamable<User> findByNameContaining(String name, Sort sort);

    @Query("select u from User u")
    Stream<User> findAllByCustomQueryAndStream();

    @Query("{ 'firstname' : ?0 }")
    List<User> findByThePersonsFirstname(String firstname);

    @Async
    Future<User> findByFirstname(String firstname);

    @Async
    CompletableFuture<User> findOneByFirstname(String firstname);

}
