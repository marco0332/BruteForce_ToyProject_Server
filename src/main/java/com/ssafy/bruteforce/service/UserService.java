package com.ssafy.bruteforce.service;


import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.dto.User;

public interface UserService{

    public ResultJson addUser(User user);
    
    public ResultJson updateUser(User user);
    
    public ResultJson deleteUserById(String id);
    
    public ResultJson deactivateUserById(String id);
    
    public ResultJson findAllUserByName(String name);
    
    /** 회원 전체 검색 */
    // public List<User> searchAllUser(PageBean bean); // TODO:페이지 빈 구현
    
    public ResultJson login(String id, String pw);
    
    public ResultJson existsById(String id);
    
	public ResultJson findUserById(String id);

    public ResultJson findAllUserQnAInfoById(String id);
}