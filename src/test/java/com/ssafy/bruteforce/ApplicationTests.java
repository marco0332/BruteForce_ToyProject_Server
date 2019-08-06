package com.ssafy.bruteforce;

import java.util.ArrayList;

import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    UserRepository userTest;

	@Test
	public void contextLoads() {
        User user0 = new User("userid", "pw", "name", "photoURL", 100);
        User user1 = new User("leekiin", "pw", "name", "", 100);
        ArrayList<User> list = new ArrayList<User>();
        User user2 =  new User("jhi", "pw", "name", "", 100);
        User user3 =  new User("phb", "pw", "name", "", 100);
        list.add(user2);
        list.add(user3);
        userTest.insert(user1);
        userTest.insert(list);
        
        System.out.println("=======================================");
        System.out.println("id로 찾아보기");
        System.out.println(userTest.findById("userid"));
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("전부 다 찾아보기");
        System.out.println(userTest.findAll());
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("id로 삭제하기");
        userTest.deleteById("userid");
        System.out.println("삭제 후 결과");
        System.out.println(userTest.findAll());
        System.out.println("=======================================");
        userTest.deleteById("leekiin");
        userTest.deleteById("jhi");
        userTest.deleteById("phb");
	}

}
