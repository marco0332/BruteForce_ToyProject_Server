package com.ssafy.bruteforce.controller;

import java.util.List;

import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BoardController{
    
    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/findAllQuestions")
	public ResponseEntity<List<Question>> findAllQuestions() throws Exception {
        List<Question> userQnAInfo = boardService.findAllQuestions();
		if (userQnAInfo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Question>>(userQnAInfo, HttpStatus.OK);
	}

}