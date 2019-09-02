package com.example.project.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Class Name : Logging.java
 * @Description : Logging Class
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019.09.02               버그 수정
 *
 * @author yunyc
 * @since 2019. 07.01
 * @version 1.0
 * @see
 *
 */

@Aspect
@Component
public class Logging {
	/** 로깅 */
	private static final Logger logger = LoggerFactory.getLogger(Logging.class);
	
	/**
	 * 컨트롤러 메서드 시작, 종료 로그 출력
	 * @param jp - jointpoint ProceedingJoinPoint
	 * @exception Exception
	 */
	@Around("execution(* com.example.project.*.web.*Controller.*(..))")
    public Object controller(ProceedingJoinPoint jp) throws Throwable {
		// 메서드가 호출되기 전에 먼저 실행되는 코드
		   logger.info(jp.getSignature().getName() + " 시작");
		   // 메서드가 호출되는 시점
		   Object result = jp.proceed();
		    // 메서드가 호출된 실행되는 코드
		   logger.info(jp.getSignature().getName() + " 종료");
		   return result;
    }
	
	/**
	 * 서비스 메서드 시작, 종료 로그 출력
	 * @param jp - jointpoint ProceedingJoinPoint
	 * @exception Exception
	 */
	@Around("execution(* com.example.project.*.service..impl.*ServiceImpl.*(..))")
    public Object service(ProceedingJoinPoint jp) throws Throwable {
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
