package com.protick.learnspringaop.aopexample.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspects {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Before("com.protick.learnspringaop.aopexample.aspect.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called - {}",joinPoint);
    }

    @After("com.protick.learnspringaop.aopexample.aspect.CommonPointCutConfig.businessAndDataPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",joinPoint);
    }

    @AfterThrowing(
            pointcut = "com.protick.learnspringaop.aopexample.aspect.CommonPointCutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {
        logger.info("After Throwing - {} has executed has thrown an exception {}",joinPoint,exception);
    }


    @AfterReturning(
            pointcut = "com.protick.learnspringaop.aopexample.aspect.CommonPointCutConfig.businessAndDataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
        logger.info("After Returning Aspect - {} has executed with return {}",joinPoint,resultValue);
    }
 }
