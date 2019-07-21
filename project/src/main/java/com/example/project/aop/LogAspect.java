package com.example.project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Around("execution(* com.example.project.*.web.*Controller.*(..))")
    public Object measure(ProceedingJoinPoint jointPoint) throws Throwable {
		// 메서드가 호출되기 전에 먼저 실행되는 코드
		   logger.info("시작");
		   // 메서드가 호출되는 시점
		   Object result = jointPoint.proceed();
		    // 메서드가 호출된 실행되는 코드
		   logger.info("끝");
		   return result;
    }

}
