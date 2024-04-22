package ru.aston.intensive.productservice.service;

import org.springframework.stereotype.Service;
import ru.aston.intensive.productservice.dto.ProductResp;

import java.util.List;

@Service
public interface ProductService {
    ProductResp getProductById(Integer id);

    List<ProductResp> getAllProducts();

}
