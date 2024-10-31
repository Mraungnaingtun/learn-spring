package com.trainSpringBoot.logant.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.util.Streamable;

import com.trainSpringBoot.logant.Entity.User;
import com.trainSpringBoot.logant.Projections.UserSummary;

import java.util.List;
public interface UserRepo extends MongoRepository<User, String> {
    List<User> findByPassword(String password);
    UserSummary findByEmailAndPassword(String email,String password);

    Streamable<User> findByNameContaining(String name);
}
