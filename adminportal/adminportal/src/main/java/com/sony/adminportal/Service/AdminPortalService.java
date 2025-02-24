package com.sony.adminportal.Service;

import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;

public interface AdminPortalService
{
    public Customer customerInfo(Customer customer);
    public Customer getCustomerById(String customerId);
    public Customer getByID(Integer id);
    public Object[] getCustomerNameAndProductNameByMobileNumber(String mobileNumber);
    public Customer getByMobileNumber(String mobileNUmber);
    public Customer getCustomerNameAndAddressByMobileNumber(String mobileNumber);
    public ResponseModel saveCustomerAndProduct(RequestModel requestModel);
    public String getOrderIdFromCourier();
}
