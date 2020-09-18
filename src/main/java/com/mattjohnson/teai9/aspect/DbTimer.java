package com.mattjohnson.teai9.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DbTimer {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startNanos = System.nanoTime();
        long startMilis = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTimeMilis = System.currentTimeMillis() - startMilis;
        long executionTimeNanos = System.nanoTime() - startNanos;
        log.info(joinPoint.getSignature() + " executed in " + executionTimeMilis + "ms; " + executionTimeNanos + " nanoseconds");
        return proceed;
    }


}
