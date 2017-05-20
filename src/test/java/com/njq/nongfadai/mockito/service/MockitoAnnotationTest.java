/**
 * Project Name:mockito-showcase
 * File Name:MockitoAnnotationTest.java
 * Package Name:com.njq.nongfadai.mockito.service
 * Date:2017年5月20日下午5:31:54
 * Copyright (c) 2017, yangjie_software@163.com All Rights Reserved.
*/

package com.njq.nongfadai.mockito.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.AtLeast;

import com.njq.nongfadai.mockito.bean.User;
/**
 * ClassName: MockitoAnnotationTest
 * Description: TODO.
 * Date: 2017年5月20日 下午5:31:54
 * Copyright (c) 2017, yangjie_software@163.com All Rights Reserved
 * Author: Jerrik
 */
public class MockitoAnnotationTest {
	@Mock
	private IUserService userService;

	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAdd(){
		Mockito.doNothing().when(userService).addUser(Mockito.any(User.class));// 当addUser(任意user对象)时,都不执行其他操作
		userService.addUser(null);
		
		Mockito.verify(userService,Mockito.atLeast(1)).addUser(Mockito.any(User.class));//针对没有返回值的方法 做校验
	}
}

