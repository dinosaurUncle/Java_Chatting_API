package me.dinosauruncle.chatting_api.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class AccountAOP {

    @Autowired
    private Map<String, Object> parameterMap;

    @Before("execution(* me.dinosauruncle.chatting_api.service.AccountService.*(..))")
    public Object parameterMapClean(ProceedingJoinPoint pip) throws Throwable{
        parameterMap.clear();
        Object retVal = pip.proceed();
        return retVal;
    }

}
