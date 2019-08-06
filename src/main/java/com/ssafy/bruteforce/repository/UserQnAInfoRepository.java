package com.ssafy.bruteforce.repository;
import com.ssafy.bruteforce.dto.UserQnAInfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserQnAInfoRepository extends MongoRepository<UserQnAInfo, String>{
}