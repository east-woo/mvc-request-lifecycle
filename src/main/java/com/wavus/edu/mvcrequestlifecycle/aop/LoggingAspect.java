package com.wavus.edu.mvcrequestlifecycle.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.wavus.edu.mvcrequestlifecycle.controller..*(..))") // 컨트롤러 실행 전
    public void logBefore(JoinPoint joinPoint) {
        logger.info("🔹 [AOP] 실행 전: {}", joinPoint.getSignature());
    }

    @AfterReturning("execution(* com.wavus.edu.mvcrequestlifecycle.controller..*(..))") // 정상 실행 후
    public void logAfterReturning(JoinPoint joinPoint) {
        logger.info("🔹 [AOP] 실행 후 (정상 반환): {}", joinPoint.getSignature());
    }

    @AfterThrowing(value = "execution(* com.wavus.edu.mvcrequestlifecycle.controller..*(..))", throwing = "ex") // 예외 발생 시
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        logger.error("❌ [AOP] 예외 발생: {} - {}", joinPoint.getSignature(), ex.getMessage());
    }
}