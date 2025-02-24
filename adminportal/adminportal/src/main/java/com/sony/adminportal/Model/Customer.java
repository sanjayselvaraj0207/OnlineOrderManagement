package com.sony.adminportal.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String customerId;
    private String customerName;
    private String mobileNumber;
    private String address;
    private String productName;
    public Customer(String customerName, String address)
    {
        this.customerName = customerName;
        this.address = address;
    }
}
