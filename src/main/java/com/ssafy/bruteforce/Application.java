package com.ssafy.bruteforce;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
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
		// service.addAnswer(new Answer("wuid","ryeong","답변이어유!!"), "5d4a42ca61cbaa37ec3a7868");
		// service.deleteAnswer("5d4a9e3261cbaa26b809bd20", "5d4a42ca61cbaa37ec3a7868");
		// service.addQuestionComment(new Comment("cwriter","bini","아무코멘트EHEHEHEHEHEHEH남겨봄"),"5d4a42ca61cbaa37ec3a7868");
		// service.addAnswerComment(new Comment("cwriterrr","bini","댓글또남긴당"),"5d4a43ab61cbaa11189d9169","5d4a42ca61cbaa37ec3a7868");
		// service.updateAnswer("5d4a43ab61cbaa11189d9169", "바껴라 순순히말할때!", "5d4a42ca61cbaa37ec3a7868");
		// service.updateQuestionComment("ㅁㄷㄱㅁㄴㅇㄻㅊㅍㅁ", "5d4a9f6161cbaa37a042c29d", "5d4a42ca61cbaa37ec3a7868");
		// service.updateAnswerComment("바껴껴껴껴껴껴", "5d4a9f3061cbaa2ed086cc79", "5d4a42ca61cbaa37ec3a7868", "5d4a43ab61cbaa11189d9169");
		// service.deleteQuestionComment("5d4a9f6161cbaa37a042c29d", "5d4a42ca61cbaa37ec3a7868");
		// service.deleteAnswerComment("5d4a9f3061cbaa2ed086cc79", "5d4a42ca61cbaa37ec3a7868", "5d4a43ab61cbaa11189d9169");
		// service.closedUpdate("5d4a42ca61cbaa37ec3a7868", "5d4a43ab61cbaa11189d9169");
	}
}
