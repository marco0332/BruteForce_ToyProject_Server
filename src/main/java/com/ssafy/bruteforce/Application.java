package com.ssafy.bruteforce;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.repository.AnswerRepository;
import com.ssafy.bruteforce.service.BoardServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private BoardServiceImpl service;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		// service.addQuestion(new Question("what","qContents1","qWriter1","qWriterName1",new String[] {"java","c"}));
		// service.addQuestion(new Question("what","qContents2","bin","qWriterName2",new String[] {"unity","vuetify"}));
		// service.addQuestion(new Question("hihi","qContents3","bin","qWriterName3",new String[] {"unity","vuetify"}));
		service.addAnswer(new Answer("wuid","ryeong","답변이어유!!"), "5d4930c561cbaa35f8b7c681");
		// service.deleteAnswer("Answer", "5d4930c561cbaa35f8b7c681");
	}


}
