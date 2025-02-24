package com.sony.adminportal.Repository;

import com.sony.adminportal.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
