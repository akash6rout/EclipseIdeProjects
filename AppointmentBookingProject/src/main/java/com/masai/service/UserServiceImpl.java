package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.User;
import com.masai.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User registerUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserByemail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserCredentials(Integer id, User User) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Integer id) {
		
		User user = userRepo.findById(id).get();
		
		userRepo.deleteById(id);
		
		return user;
	}

}
