package com.sony.adminportal.Validator;

import com.sony.adminportal.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductValidate
{
    public boolean isProductValidate(Product product)
    {
        return product.getBrandName().equalsIgnoreCase("Sony");
    }
}
