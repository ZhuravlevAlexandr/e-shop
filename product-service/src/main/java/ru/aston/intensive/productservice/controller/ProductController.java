package ru.aston.intensive.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.intensive.productservice.dto.ProductResp;
import ru.aston.intensive.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResp> getProductById(@PathVariable("id") Integer id) {
        ProductResp productResp = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResp);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResp>> getAllProducts() {
        List<ProductResp> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
