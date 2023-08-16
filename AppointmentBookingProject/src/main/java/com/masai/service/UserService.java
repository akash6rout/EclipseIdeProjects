package com.masai.service;

import com.masai.model.User;

public interface UserService {

	User registerUser(User user);
	User getUserByemail(String email);
	User getUserByMobile(String mobile);
	User updateUserCredentials(Integer id, User User);
	User deleteUser(Integer id);
}
