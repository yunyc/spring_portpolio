package com.example.project.aop;

import java.util.Arrays;

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
    public Object measure(ProceedingJoinPoint jp) throws Throwable {
		// 메서드가 호출되기 전에 먼저 실행되는 코드
		   logger.info(jp.getSignature().getName() + " 시작");
		   // 메서드가 호출되는 시점
		   Object result = jp.proceed();
		    // 메서드가 호출된 실행되는 코드
		   logger.info(jp.getSignature().getName() + " 종료");
		   return result;
    }
	
	@Around("execution(* com.example.project.*.service..impl.*ServiceImpl.*(..))")
    public Object meas(ProceedingJoinPoint jp) throws Throwable {
		// 메서드가 호출되기 전에 먼저 실행되는 코드
		   logger.info("메서드 명: " + jp.getSignature().getName() + " 시작");
	       logger.info("파라미터: " + Arrays.toString(jp.getArgs()));
		   // 메서드가 호출되는 시점
		   Object result = jp.proceed();
		    // 메서드가 호출된 실행되는 코드
		   logger.info("메서드 명: " + jp.getSignature().getName() + " 종료");
		   return result;
    }

}
