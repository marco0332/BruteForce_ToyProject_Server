package com.ssafy.bruteforce.controller;

import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.dto.User;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
	private UserService userService;

	@ApiOperation(value = "회원 가입")
	@PostMapping(value="/addUser")
	public ResponseEntity<ResultJson> addUser(User user) {
		ResultJson resultJson = userService.addUser(user);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "회원 정보 수정")
	@PutMapping(value="/updateUser")
	public ResponseEntity<ResultJson> updateUser(User user){
		ResultJson resultJson = userService.updateUser(user);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "회원 정보 삭제")
	@DeleteMapping(value="/deleteUserById")
	public ResponseEntity<ResultJson> deleteUserById(String id){
		ResultJson resultJson = userService.deleteUserById(id);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "답변 채택시 수정 불가")
	@PutMapping(value="/deactivateUserById")
	public ResponseEntity<ResultJson> deactivateUserById(String id){
		ResultJson resultJson = userService. deactivateUserById(id);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "이름으로 전체 회원 찾기")
	@GetMapping(value="/findAllUserByName/{name}")
	public ResponseEntity<ResultJson> findAllUserByName(@PathVariable String name){
		ResultJson resultJson = userService.findAllUserByName(name);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "로그인")
	@PostMapping(value="/login")
	public ResponseEntity<ResultJson> login(String id, String pw){
		ResultJson resultJson = userService.login(id, pw);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "ID 중복체크")
	@PostMapping(value="/existsById")
	public ResponseEntity<ResultJson> existsById(String id){
		ResultJson resultJson = userService.existsById(id);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "ID로 유저 찾기")
	@GetMapping(value="/findUserById/{id}")
	public ResponseEntity<ResultJson> findUserById(@PathVariable String id){
		ResultJson resultJson = userService.findUserById(id);
		return responseFunction(resultJson);
	}

	@ApiOperation(value = "ID에 해당하는 모든 게시글 찾기")
    @GetMapping(value = "/findAllUserQnAInfoById/{id}")
	public ResponseEntity<ResultJson> findAllUserQnAInfoById(@PathVariable String id) throws Exception {
		ResultJson resultJson = userService.findAllUserQnAInfoById(id);
		return responseFunction(resultJson);
	}
	
	private ResponseEntity<ResultJson> responseFunction(ResultJson resultJson) {
		switch(resultJson.getState()){
			case "fail":
				return new ResponseEntity<ResultJson>(resultJson,HttpStatus.NO_CONTENT);
			case "unconnect":
				return new ResponseEntity<ResultJson>(resultJson,HttpStatus.INTERNAL_SERVER_ERROR);
			default:
				return new ResponseEntity<ResultJson>(resultJson,HttpStatus.OK);
		}
	}
}