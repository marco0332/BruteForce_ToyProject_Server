package com.ssafy.bruteforce.controller;

import java.util.List;

import com.ssafy.bruteforce.dto.UserQnAInfo;
import com.ssafy.bruteforce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
    private UserService userService;
    
    // @GetMapping(value = "/findAllUserQnAInfo/{id}")
	// public ResponseEntity<List<UserQnAInfo>> findAllUserQnAInfo(@PathVariable String id) throws Exception {
    //     List<UserQnAInfo> userQnAInfo = userService.findAllUserQnAInfo(id);
	// 	if (userQnAInfo.isEmpty()) {
	// 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// 	}
	// 	return new ResponseEntity<List<UserQnAInfo>>(userQnAInfo, HttpStatus.OK);
	// }



}