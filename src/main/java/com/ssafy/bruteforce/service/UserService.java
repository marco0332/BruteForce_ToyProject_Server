package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.User;

public interface UserService{
    /** 회원 가입 */
    public void signupUser(User user);
    
	/** 회원 정보 수정 */
    public void updateUser(User user);
    
	/** 회원 정보 삭제 */
    public void deleteUser(String id);
    
	/** 회원 탈퇴 표시 */
    public void withdrawUser(String id);
    
	/** 유저 id로 검색 */
    public User searchUser(String id);
    
    /** 회원 전체 검색 */
    // public List<User> searchAllUser(PageBean bean); // TODO:페이지 빈 구현
    
	/** 로그인 확인 */
    public boolean login(User user);
    
	/** ID 중복체크 */
    public boolean idCheck(String id);
    
	/** ID 찾기 */
	public List<User> findId(User user);

    
}