package com.njq.nongfadai.mockito.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class VerifyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		// mock creation
		LinkedList<String> mockedList = mock(LinkedList.class);

		// using mock object
		mockedList.add("one");
		mockedList.clear();
		// verification
		verify(mockedList,atLeast(1)).add("one");
		verify(mockedList).clear();
	}

}
