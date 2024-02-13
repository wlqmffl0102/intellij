package com.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution (* com.study..*Controller.*(..)) || execution(* com.study..*Service.*(..)) || execution(* com.study..*Mapper.*(..))")
    public Object PrintLog(ProceedingJoinPoint joinPoint) throws Throwable{
        String name = joinPoint.getSignature().getDeclaringTypeName();
        String type =
                StringUtils.contains(name,"Controller") ? "Controller ==>" :
                StringUtils.contains(name, "Service") ? "Service ==>" :
                StringUtils.contains(name, "Mapper") ? "Mapper ==>":
                                        "";
        log.debug(type+name+"."+joinPoint.getSignature().getName()+"()");
        return joinPoint.proceed();
    }
}
