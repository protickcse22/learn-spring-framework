package com.protick.learnspringaop.aopexample.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.protick.learnspringaop.aopexample.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.protick.learnspringaop.aopexample.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.protick.learnspringaop.aopexample.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void dataPackageConfigBean() {}

    @Pointcut("@annotation(com.protick.learnspringaop.aopexample.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
