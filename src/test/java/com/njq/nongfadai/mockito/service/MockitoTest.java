package com.njq.nongfadai.mockito.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {

	@Test
	public void testMockitoList() throws Exception {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn(1);
		System.out.println(mockList.get(0));
		verify(mockList,times(2)).get(0);
	}

	@Test
	public void testThrowException() throws Exception {
		IUserService userService = mock(IUserService.class);
		when(userService.print()).thenThrow(new RuntimeException("doThrowException 异常"));//有返回值的情况
		//userService.print();
		
		//如果无返回值  Mockito.when(userService.noResult()) 报错 必须使用以下方法替代
		Mockito.doThrow(new RuntimeException("doThrowException")).when(userService).print();
		//userService.print();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testDoReturn(){
		List mockList = mock(List.class);
		Mockito.doReturn("ok").when(mockList).get(2);
		
		System.out.println(mockList.get(0));
		System.out.println(mockList.get(2));
	}
	
	//只有void的方法 才能doNothing
	@Test
	public void testDoNothing(){
		IUserService userService = mock(IUserService.class);
		Mockito.doNothing().when(userService).noResult();
		
		userService.noResult();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testVerify(){
		LinkedList mockList = Mockito.mock(LinkedList.class);
		mockList.add("hello1");
		mockList.add("hello2");
		mockList.add("hello3");
		
		//Mockito.verify(mockList,Mockito.times(3)).add(Mockito.anyString());
		
		//Mockito.verify(mockList).get(0);
		Mockito.verify(mockList,Mockito.atLeast(1)).add(Mockito.anyString());// 调用add(任意字符串)至少一次,否则抛出异常
	}
	
	//对象监视
	@Test
	@SuppressWarnings("unchecked")
	public void testSpy(){
		LinkedList<String> llist = new LinkedList<String>();
		LinkedList<String> spyList = Mockito.spy(llist);
		spyList.add("hello_1");
		spyList.add("world");
	}
}
