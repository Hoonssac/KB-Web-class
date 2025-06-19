package org.scoula.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Log4j2
@Component
public class LogAdvice {

	@Before("execution(* org.scoula.service.MessageService.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("✅ [Before] 호출된 메서드: {}", methodName);
		log.info("✅ [Before] 전달된 파라미터: {}", Arrays.toString(args));
	}

	@AfterThrowing(pointcut = "execution(* org.scoula.service.MessageService.*(..))", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
		String className = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();
		log.error("❌ [AfterThrowing] 예외 발생: {}", exception.getMessage());
		log.error("❌ [AfterThrowing] 대상 메서드: {}.{}(...)", className, methodName);
	}

	@Around("execution(* org.scoula.service.MessageService.*(..))")
	public Object measureExceptionTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = pjp.proceed();
		long end = System.currentTimeMillis();

		String methodName = pjp.getSignature().getName();
		log.info("⏱ [Around] {} 실행시간: {} ms", methodName, (end - start));
		return result;
	}
}
