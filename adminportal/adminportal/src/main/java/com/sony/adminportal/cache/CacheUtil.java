package com.sony.adminportal.cache;

import com.sony.adminportal.Model.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheUtil
{
    private Map<String, Customer> cacheMap;
    @PostConstruct
    public void init()
    {
        cacheMap = new ConcurrentHashMap<>();
    }
    public boolean isKeyPresent(String mobileNumber)
    {
        return cacheMap.containsKey(mobileNumber);
    }
    public Customer init(String mobileNumber)
    {
        return cacheMap.get(mobileNumber);
    }
    public Customer insertCache(String mobileNumber, Customer customer)
    {
        cacheMap.put(mobileNumber, customer);
        return customer;
    }
}
