package com.ssafy.bruteforce.controller;

import java.util.List;

import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.dto.UserQnAInfo;
import com.ssafy.bruteforce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
	private UserService userService;

	@PostMapping(value="/addUser")
	public ResponseEntity<String> addUser(User user) {
		try{
			userService.addUser(user);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@PutMapping(value="/updateUser/{user}")
	public ResponseEntity<String> updateUser(User user){
		try{
			userService.updateUser(user);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@DeleteMapping(value="/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(String id){
		try{
			userService.deleteUser(id);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@PutMapping(value="/deactivateUser/{id}")
	public ResponseEntity<String> deactivateUser(String id){
		try{
			userService.deactivateUser(id);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	// public User searchUser(String id);

	@PostMapping(value="/login")
	public ResponseEntity<String> login(User user){
		boolean result = userService.login(user);
		if(!result){
			return new ResponseEntity<>("false",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	//  public boolean idCheck(String id);

	// public List<User> findId(User user);

    @GetMapping(value = "/findAllUserQnAInfo/{id}")
	public ResponseEntity<List<UserQnAInfo>> findAllUserQnAInfo(@PathVariable String id) throws Exception {
        List<UserQnAInfo> userQnAInfo = userService.findAllUserQnAInfo(id);
		if (userQnAInfo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserQnAInfo>>(userQnAInfo, HttpStatus.OK);
	}




}