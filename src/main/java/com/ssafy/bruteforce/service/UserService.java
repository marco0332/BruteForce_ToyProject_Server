package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.dto.UserQnAInfo;

public interface UserService{

    public void addUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUserById(String id);
    
    public void deactivateUserById(String id);
    
    public List<User> findAllUserByName(String name);
    
    /** 회원 전체 검색 */
    // public List<User> searchAllUser(PageBean bean); // TODO:페이지 빈 구현
    
    public boolean login(String id, String pw);
    
    public boolean existsById(String id);
    
	public User findUserById(String id);

    public List<UserQnAInfo> findAllUserQnAInfoById(String id);
}