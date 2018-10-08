package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAnyMethodInDaoPackage() {
		System.out.println("\n=====>>> Executing @Before any method of any class in com.luv2code.aopdemo.dao");		
	}
	
	@Before("forDaoPackage()")	
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");		
	}
	
//	@AfterReturning(pointcut="forDaoPackage()", returning="result")	
//	public void afterReturningMethodInDaoPackage(JoinPoint jp, Object result) {
//		System.out.println("\n=====>>> result is: " + result);		
//	}	
}
