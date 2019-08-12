package com.ssafy.bruteforce.repository;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.ssafy.bruteforce.dto.UserQnAInfo;


public interface UserQnAInfoRepository extends DocumentDbRepository<UserQnAInfo, String>{
}