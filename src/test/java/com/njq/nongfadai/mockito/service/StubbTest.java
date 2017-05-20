package com.njq.nongfadai.mockito.service;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class StubbTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LinkedList<String> llist = Mockito.mock(LinkedList.class);
		Mockito.when(llist.get(1)).thenReturn("user");
		Mockito.when(llist.get(2)).thenReturn("who");
		Mockito.when(llist.get(3)).thenThrow(new RuntimeException());

		System.out.println(llist.get(1));
		System.out.println(llist.get(2));
		System.out.println(llist.get(3));
	}

}
