package com.sony.adminportal.AOP;

import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.cache.CacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CacheAspect
{
    @Autowired
    private CacheUtil cacheUtil;
    //@Around("execution(* com.sony.adminportal.Service.AdminPortalServiceImpl.getByMobileNumber(..))")
    public Customer execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Customer customer = null;
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        String mobileNumber = (String) proceedingJoinPoint.getArgs()[0];

        System.out.println("Class Name = "+className);
        System.out.println("Method Name = "+methodName);
        System.out.println("MobileNumber = "+mobileNumber);

        if(cacheUtil.isKeyPresent(mobileNumber))
        {
            customer = cacheUtil.init(mobileNumber);
            System.out.println("Retrieved Customer details from local Cache");
        }
        else
        {
            customer = (Customer) proceedingJoinPoint.proceed();
            cacheUtil.insertCache(mobileNumber, customer);
            System.out.println("Retrieved Customer details from database");
        }
        return customer;
    }
}
