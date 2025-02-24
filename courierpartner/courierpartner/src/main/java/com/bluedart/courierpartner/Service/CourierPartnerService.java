package com.bluedart.courierpartner.Service;

import org.springframework.stereotype.Service;

@Service
public class CourierPartnerService
{
    public String transport()
    {
        String orderId = generateId();
        System.out.println("Order Id = "+orderId);
        return "Order Id = "+orderId;
    }
    public String generateId()
    {
        Double randomValue = Math.random();
        String orderId = randomValue.toString().substring(2).substring(0,6);
        return orderId;
    }
}
