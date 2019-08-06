package com.ssafy.bruteforce;


import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    UserService userTest;

	@Test
	public void userServiceTest() {
        User user1 = new User("1", "null", "null", "null", 0);
        User user2 = new User("2", "null", "null", "null", 0);
        User user3 = new User("3", "null", "null", "null", 0);
        User user4 = new User("4", "null", "null", "null", 0);
        System.out.println("=====user add test=====");
        userTest.addUser(user1);
        userTest.addUser(user2);
        userTest.addUser(user3);
        userTest.addUser(user4);
        System.out.println("=====findAllUserByName test====");
        System.out.println(userTest.findAllUserByName("nu"));
        System.out.println("=====deleteUserById test====");
        userTest.deleteUserById("1");
        System.out.println(userTest.findAllUserByName("null"));
        System.out.println("=====updateUser test====");
        user4.setName("nasdf");
        userTest.updateUser(user4);
        userTest.deactivateUserById("2");
        System.out.println(userTest.findAllUserByName("null"));
        System.out.println("=====findUserById test====");
        System.out.println(userTest.findUserById("4"));
        userTest.deleteUserById("2");
        userTest.deleteUserById("3");
        userTest.deleteUserById("4");
	}
}
