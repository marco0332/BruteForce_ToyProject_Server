package com.ssafy.bruteforce.repository;

import java.util.List;

import com.ssafy.bruteforce.dto.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByNameLike(String name);
}