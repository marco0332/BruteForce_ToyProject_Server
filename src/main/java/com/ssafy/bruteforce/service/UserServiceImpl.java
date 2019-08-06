package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.dto.UserQnAInfo;
import com.ssafy.bruteforce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public void deactivateUser(String id) {

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

    @Override
    public List<UserQnAInfo> findAllUserQnAInfo(String id) {
        return null;
	}

}