package com.sony.adminportal.Repository;

import com.sony.adminportal.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
    Customer findByCustomerId(String customerId);

    @Query(value = "select customer_name, product_name from customer where mobile_number = :mobileNumber", nativeQuery = true)
    Object[] findCustomerNameAndProductNameByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("select customer1 from Customer customer1 where customer1.mobileNumber = :mobileNumber")
    Customer findByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("select new Customer(customerName, address) from Customer c where c.mobileNumber = :mobileNumber")
    Customer findCustomerNameAndAddressByMobileNumber(@Param("mobileNumber") String mobileNumber);
}
