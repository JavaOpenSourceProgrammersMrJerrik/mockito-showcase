package com.njq.nongfadai.mockito.service;

import com.njq.nongfadai.mockito.bean.User;

public interface IUserService {

	public int addUser(User user);

	public int deleteUserById(Integer id);

	public int updateUser(User user);

	public User findUser(User user);
	
	public String print();
	
	public void noResult();
}
