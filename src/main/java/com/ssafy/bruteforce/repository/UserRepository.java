package com.ssafy.bruteforce.repository;

import java.util.List;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.ssafy.bruteforce.dto.User;


public interface UserRepository extends DocumentDbRepository<User,String> {
    List<User> findByNameLike(String name);
}