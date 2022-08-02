package tn.esprit.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
@Aspect
public class LoggingAspect {

	@Before("execution(* tn.esprit.services.StockServiceImpl.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	log.info("In method " + name + " : ");
	}

	@AfterReturning("execution( public * tn.esprit.services.StockServiceImpl.* (..))")
	public void logMethodExit1(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	log.info("Out of method without errors  "+name);
	}

	@AfterThrowing("execution( public * tn.esprit.services.StockServiceImpl.* (..))")
	public void logMethodExit2(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	log.info("Out of method without errors  "+name);
	}
}
