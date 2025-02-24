package com.sony.adminportal.AOP;

import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Validator.MobileNumberValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidatorAspect
{
    @Autowired
    private MobileNumberValidator mobileNumberValidator;
    @Before("execution (* com.sony.adminportal.Service.AdminPortalServiceImpl.getByMobileNumber(..))")
    public Customer execute(JoinPoint joinPoint)
    {
        Customer customer = null;
        String className = joinPoint.getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String mobileNumber = (String) joinPoint.getArgs()[0];

        if(mobileNumberValidator.mobileValidate(mobileNumber))
        {
            System.out.println("Mobile Number is valid");
        }
        else
        {
            throw new IllegalArgumentException("Not a valid MobileNumber");
        }
        return customer;
    }
}
