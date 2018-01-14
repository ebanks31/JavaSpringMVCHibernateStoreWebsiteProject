package com.ebanks.springapp.aspects;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.ebanks.springapp.controllers.HomeController;

@Aspect
public class UserLoggingAspect {
	private static final Logger USER_ASPECT_LOGGER = Logger.getLogger(UserLoggingAspect.class);

	@Before("execution(*com.ebanks.springapp.dao.addUser(..))")
	public void logBefore(JoinPoint joinPoint) {

		USER_ASPECT_LOGGER.info("logBefore() runs");
		USER_ASPECT_LOGGER.info("Getting joinpoint signature name: " + joinPoint.getSignature().getName());
	}

	@After("execution(*com.ebanks.springapp.dao.addUser(..))")
	public void logAfter(JoinPoint joinPoint) {

		USER_ASPECT_LOGGER.info("logAfter() runs");
		USER_ASPECT_LOGGER.info("Getting joinpoint signature name: " + joinPoint.getSignature().getName());

	}

	@Around("execution(*com.ebanks.springapp.dao.addUser(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		USER_ASPECT_LOGGER.info("logAround() runs");
		USER_ASPECT_LOGGER.info("Getting joinpoint signature name: " + joinPoint.getSignature().getName());
		USER_ASPECT_LOGGER.info("Getting joinpoint arguments : " + Arrays.toString(joinPoint.getArgs()));

		USER_ASPECT_LOGGER.info("Around before runs");
		joinPoint.proceed(); // continue on the intercepted method
		USER_ASPECT_LOGGER.info("Around after runs");
	}

	//TODO: Need to add aspect loggers to log to make sure all DAO layers is running correctly and efficiently.

}