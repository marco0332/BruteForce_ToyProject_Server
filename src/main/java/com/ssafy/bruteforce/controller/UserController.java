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

	@PutMapping(value="/updateUser")
	public ResponseEntity<String> updateUser(User user){
		try{
			userService.updateUser(user);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@DeleteMapping(value="/deleteUserById")
	public ResponseEntity<String> deleteUserById(String id){
		try{
			userService.deleteUserById(id);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@PutMapping(value="/deactivateUserById")
	public ResponseEntity<String> deactivateUserById(String id){
		try{
			userService.deactivateUserById(id);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@GetMapping(value="/findAllUserByName")
	public ResponseEntity<List<User>> findAllUserByName(String name){
		List<User> users;
		try{
			users = userService.findAllUserByName(name);
			
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}

	@PostMapping(value="/login")
	public ResponseEntity<String> login(String id, String pw){
		boolean result = userService.login(id,pw);
		if(!result){
			return new ResponseEntity<>("false",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@PostMapping(value="/existsById")
	public ResponseEntity<String> existsById(String id){
		boolean result = userService.existsById(id);
		if(!result){
			return new ResponseEntity<>("false",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}

	@GetMapping(value="/findUserById/{id}")
	public ResponseEntity<User> findUserById(@PathVariable String id){
		User user;
		try{
			user = userService.findUserById(id);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

    @GetMapping(value = "/findAllUserQnAInfoById/{id}")
	public ResponseEntity<List<UserQnAInfo>> findAllUserQnAInfoById(@PathVariable String id) throws Exception {
        List<UserQnAInfo> userQnAInfo = userService.findAllUserQnAInfoById(id);
		if (userQnAInfo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserQnAInfo>>(userQnAInfo, HttpStatus.OK);
	}
}