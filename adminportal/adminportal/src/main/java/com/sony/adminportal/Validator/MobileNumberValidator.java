package com.sony.adminportal.Validator;

import org.springframework.stereotype.Component;

@Component
public class MobileNumberValidator
{
    public boolean mobileValidate(String mobileNumber)
    {
        return mobileNumber.length()<=10;
    }
}
