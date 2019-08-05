package com.ssafy.bruteforce.controller;

import com.ssafy.bruteforce.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController{
    
    @Autowired
    private BoardService boardService;

}