package com.ssafy.bruteforce.controller;

import com.ssafy.bruteforce.service.UserService;
import com.ssafy.bruteforce.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    
}