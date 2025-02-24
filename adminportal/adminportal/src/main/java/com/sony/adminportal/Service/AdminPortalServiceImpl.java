package com.sony.adminportal.Service;

import com.sony.adminportal.Exception.InvalidBrandName;
import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.Product;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;
import com.sony.adminportal.Repository.CustomerRepository;
import com.sony.adminportal.Repository.ProductRepository;
import com.sony.adminportal.Validator.ProductValidate;
import com.sony.adminportal.cache.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminPortalServiceImpl implements AdminPortalService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductValidate productValidate;
    @Autowired
    private CacheUtil cacheUtil;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Customer customerInfo(Customer customer)
    {
        customer.setCustomerId(generateId());
        return customerRepository.save(customer);
    }
    private String generateId()
    {
        Double randomValue = Math.random();
        String id = randomValue.toString().substring(2).substring(0,6);
        return id;
    }
    @Override
    public Customer getCustomerById(String customerId)
    {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public Customer getByID(Integer id)
    {
        return customerRepository.findById(id).get();
    }

    @Override
    public Object[] getCustomerNameAndProductNameByMobileNumber(String mobileNumber)
    {
        return customerRepository.findCustomerNameAndProductNameByMobileNumber(mobileNumber);
    }

    @Override
    public Customer getByMobileNumber(String mobileNumber)
    {
            return customerRepository.findByMobileNumber(mobileNumber);
    }

    @Override
    public Customer getCustomerNameAndAddressByMobileNumber(String mobileNumber)
    {
        return customerRepository.findCustomerNameAndAddressByMobileNumber(mobileNumber);
    }

    @Override
    public ResponseModel saveCustomerAndProduct(RequestModel requestModel)
    {
        Customer customer = requestModel.getCustomer();
        customer.setCustomerId(generateId());
        Customer customerResponse = customerRepository.save(customer);

        Product product = requestModel.getProduct();
        product.setProductCode(generateId());
        Product productResponse = null;
        if(productValidate.isProductValidate(product))
        {
            productResponse = productRepository.save(product);
        }
        else
        {
            throw new InvalidBrandName("It is not the valid Brand Name");
        }
//        ResponseModel responseModel = new ResponseModel();
//        responseModel.setCustomerId(customerResponse.getCustomerId());
//        responseModel.setProductCode(productResponse.getProductCode());
//        return responseModel;
        return ResponseModel.builder()
                .customerId(customer.getCustomerId())
                .productCode(product.getProductCode())
                .build();
    }

    @Override
    public String getOrderIdFromCourier()
    {
        String courierServiceUrl = "http://localhost:8081/courier/transport";
        ResponseEntity<String> responseEntity = restTemplate.exchange(courierServiceUrl,
                HttpMethod.GET, null, String.class);
        return responseEntity.getBody();
    }
}
