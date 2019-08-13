package com.ssafy.bruteforce;


import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.service.BoardService;
import com.ssafy.bruteforce.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    // @Autowired
    // BoardService boardTest;

    // @Autowired
    // UserService userTest;

	@Test
	public void userServiceTest() {
        // User user1 = new User("1", "null", "null", "null", 0);
        // User user2 = new User("2", "null", "null", "null", 0);
        // User user3 = new User("3", "null", "null", "null", 0);
        // User user4 = new User("4", "null", "null", "null", 0);
        // System.out.println("=====user add test=====");
        // userTest.addUser(user1);
        // userTest.addUser(user2);
        // userTest.addUser(user3);
        // userTest.addUser(user4);
        // System.out.println("=====findAllUserByName test====");
        // System.out.println(userTest.findAllUserByName("nu"));
        // System.out.println("=====deleteUserById test====");
        // userTest.deleteUserById("1");
        // System.out.println(userTest.findAllUserByName("null"));
        // System.out.println("=====updateUser test====");
        // user4.setName("nasdf");
        // userTest.updateUser(user4);
        // userTest.deactivateUserById("2");
        // System.out.println(userTest.findAllUserByName("null"));
        // System.out.println("=====findUserById test====");
        // System.out.println(userTest.findUserById("4"));
        // userTest.deleteUserById("2");
        // userTest.deleteUserById("3");
        // userTest.deleteUserById("4");
    }
    
    @Test
    public void boardTest() {
        // boardTest.addQuestion(new Question("qtitle","qcontents","qwriterid","qwritername",new String[] {"java","cpp"}));
        // boardTest.addQuestion(new Question("qtitle2","qcontents2","qwriterid2","qwritername2",new int[] {3,5}));
        // boardTest.addAnswer(new Answer("5d4d1e4a61cbaa4e607bd9cf","acontents","ariterid","awritername"));
        // boardTest.addAnswer(new Answer("5d4d1e4a61cbaa4e607bd9cf", "acontents2","ariterid2","awritername2"));
        // boardTest.addAnswer(new Answer("5d4d1e4a61cbaa4e607bd9cf", "acontents3","ariterid3","awritername3"));
        // boardTest.addAnswer(new Answer("5d4d1e4b61cbaa4e607bd9d0","a2contents","a2riterid","a2writername"));
        // boardTest.addAnswer(new Answer("5d4d1e4b61cbaa4e607bd9d0", "a2contents2","a2riterid2","a2writername2"));
        // boardTest.addAnswer(new Answer("5d4d1e4b61cbaa4e607bd9d0", "a2contents3","a2riterid3","a2writername3"));
        // boardTest.findByQid("5d4cd49161cbaa3bccb103b6");
        // boardTest.addQuestionComment("5d4d1e4a61cbaa4e607bd9cf", new Comment("cwriterid","cwriterName","ccontents"));
        // boardTest.addAnswerComment("5d4d1e8461cbaa50e8d3c0d1", new Comment("cwriterid2","cwriterName2","ccontents2"));
        // boardTest.findAllQuestions();
        // boardTest.findQuestionByTitle("qtitle");
        // boardTest.updateQuestion("5d4d1e4a61cbaa4e607bd9cf", "qtitleupdate","qcontentsupdate",new String[] {"update","tag"});
        // boardTest.deleteQuestion("5d4d1e4b61cbaa4e607bd9d0");
        // boardTest.updateAnswer("5d4d1e8461cbaa50e8d3c0d1", "답변 내용 수정되니?");
        // boardTest.deleteAnswer("5d4d1e8461cbaa50e8d3c0d2");
        // boardTest.updateQuestionComment("5d4d1e4a61cbaa4e607bd9cf", "5d4d1e8461cbaa50e8d3c0d7", "댓글도 업데이트 되나");
        // boardTest.updateAnswerComment("5d4d1e8461cbaa50e8d3c0d1", "5d4d1eb661cbaa3e98701cd4", "답변의 댓글도 업데이트 되나");
        // boardTest.deleteQuestionComment("5d4d1e4a61cbaa4e607bd9cf", "5d4d1e8461cbaa50e8d3c0d7");
        // boardTest.deleteAnswerComment("5d4d1e8461cbaa50e8d3c0d1", "5d4d1eb661cbaa3e98701cd4");
        // boardTest.closedUpdate("5d4d1e4a61cbaa4e607bd9cf", "5d4d1e8461cbaa50e8d3c0d1");
        // boardTest.findQuestionByTag(new int[] {0,0,0,1,0,1}, 2);
    }
}
