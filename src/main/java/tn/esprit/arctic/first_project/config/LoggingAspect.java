package tn.esprit.arctic.first_project.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.arctic.first_project.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning("execution(* tn.esprit.arctic.first_project.services.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }

    @After("execution(* tn.esprit.arctic.first_project.services.*.*(..))")
    public void logMethodExit1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method " + name + " : ");
    }

    @AfterThrowing(value = "execution(* tn.esprit.arctic.first_project.services.*.*(..))", throwing = "ex")
    public void logMethodException(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        log.error("Exception in method " + name + " : " + ex.getMessage());
    }
}