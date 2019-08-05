package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.User;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void withdrawUser(String id) {

    }

    @Override
    public User searchUser(String id) {
        return null;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean idCheck(String id) {
        return false;
    }

	@Override
	public List<User> findId(User user) {
		return null;
	}

}