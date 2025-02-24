package com.bluedart.courierpartner.Controller;

import com.bluedart.courierpartner.Service.CourierPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierPartnerController
{
    @Autowired
    private CourierPartnerService courierPartnerService;
    @GetMapping("/courier/transport")
    public String courierTransport()
    {
        return courierPartnerService.transport();
    }
}
