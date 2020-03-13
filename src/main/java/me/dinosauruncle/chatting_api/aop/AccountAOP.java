package me.dinosauruncle.chatting_api.aop;

import me.dinosauruncle.chatting_api.service.AccountServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountAOP {

    private Logger logger = LoggerFactory.getLogger(AccountAOP.class);

    @Before("execution(* me.dinosauruncle.chatting_api.service.AccountService.*(..))")
    public Object parameterMapClean(JoinPoint joinPoint) throws Throwable{
        logger.info("AccountService start function: " + joinPoint.getSignature().getName());
        AccountServiceImpl retVal = (AccountServiceImpl) joinPoint.getTarget();
        retVal.getParameterMap().clear();
        return retVal;
    }

    @After("execution(* me.dinosauruncle.chatting_api.service.AccountService.*(..))")
    public Object apiCallLogPrint(JoinPoint joinPoint) throws Throwable{
        logger.info("AccountService end function: " + joinPoint.getSignature().getName());
        AccountServiceImpl retVal = (AccountServiceImpl) joinPoint.getTarget();
        logger.info("return value: " + retVal.getParameterMap().toString());
        return retVal;
    }

}
