package com.sony.adminportal.Controller;

import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.Product;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;
import com.sony.adminportal.Service.AdminPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class AdminPortalController
{
    @Autowired
    private AdminPortalService adminPortalService;
    @PostMapping("/save")
    public ResponseEntity<Customer> customerInfo(@RequestBody Customer customer)
    {
        Customer customerResponse = adminPortalService.customerInfo(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerByID/{customerId}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable String customerId)
    {
        Customer customerResponse = adminPortalService.getCustomerById(customerId);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<Customer> getByID(@PathVariable Integer id)
    {
        Customer customerResponse = adminPortalService.getByID(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @GetMapping("/getCustomerNameAndProductNameByMobileNumber/{mobileNumber}")
    public ResponseEntity<?> getCustomerNameAndProductNameByMobileNumber(@PathVariable String mobileNumber)
    {
        Object[] customerResponse = adminPortalService.getCustomerNameAndProductNameByMobileNumber(mobileNumber);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @GetMapping("/getByMobileNumber/{mobileNumber}")
    public ResponseEntity<Customer> getByMobileNumber(@PathVariable String mobileNumber)
    {
        Customer customerResponse = adminPortalService.getByMobileNumber(mobileNumber);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }
    

    @GetMapping("/getCustomerNameAndAddressByMobileNumber/{mobileNumber}")
    public ResponseEntity<Customer> getCustomerNameAndAddressByMobileNumber(@PathVariable String mobileNumber)
    {
        Customer customerResponse = adminPortalService.getCustomerNameAndAddressByMobileNumber(mobileNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }

    @PostMapping("/saveCustomerAndProduct")
    public ResponseEntity<ResponseModel> saveCustomerAndProduct(@RequestBody RequestModel requestModel)
    {
        ResponseModel responseModel = adminPortalService.saveCustomerAndProduct(requestModel);
        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }

    @GetMapping("/getOrderIdFromCourier")
    public ResponseEntity<String> getOrderIdFromCourier()
    {
        String orderId = adminPortalService.getOrderIdFromCourier();
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }


    @GetMapping("/test")
    public ResponseEntity<RequestModel> getCustomerAndProduct()
    {
//        Customer customer1 = new Customer();
//        customer1.setCustomerName("Sathish");
//        Product product1 = new Product();
//        product1.setProductName("Sony");
//        RequestModel requestModel1 = new RequestModel(customer1, product1);
//        return new ResponseEntity<>(requestModel1, HttpStatus.CREATED);
        Customer customer1 = Customer.builder()
                .customerName("Sathish")
                .build();
        Product product1 = Product.builder()
                .productName("Sony")
                .build();
        RequestModel requestModel1 = RequestModel.builder()
                .customer(customer1)
                .product(product1)
                .build();
        return new ResponseEntity<>(requestModel1,HttpStatus.CREATED);
    }
}
