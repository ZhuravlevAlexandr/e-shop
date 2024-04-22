package ru.aston.intensive.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.intensive.productservice.dto.ProductResp;
import ru.aston.intensive.productservice.mapper.ProductMapper;
import ru.aston.intensive.productservice.model.repository.ProductRepo;
import ru.aston.intensive.productservice.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResp getProductById(Integer id) {
        return productMapper.toProductResp(productRepo.getReferenceById(id));
    }

    @Override
    public List<ProductResp> getAllProducts() {
        return productRepo.findAll().stream().map(productMapper::toProductResp).toList();
    }
}
