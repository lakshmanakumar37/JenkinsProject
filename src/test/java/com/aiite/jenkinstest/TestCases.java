package com.aiite.jenkinstest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aiite.jenkins.BrowserSetUp;

public class TestCases extends BrowserSetUp {
	
	@Test
	public void testCase1() {
		System.out.println("This is test case1");
	}
	
	@Test
	public void testCase2() {
		System.out.println("This is test case2");
	}
	
	@Test
	public void testCase3() {
		System.out.println("This is test case3");
	}

}
