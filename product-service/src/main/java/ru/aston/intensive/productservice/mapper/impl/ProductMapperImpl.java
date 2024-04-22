package ru.aston.intensive.productservice.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aston.intensive.productservice.dto.ProductResp;
import ru.aston.intensive.productservice.mapper.ProductMapper;
import ru.aston.intensive.productservice.model.entity.Product;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product toProduct(ProductResp productResp) {
        return Product.builder()
                .title(productResp.title())
                .price(productResp.price())
                .build();
    }

    @Override
    public ProductResp toProductResp(Product product) {
        return ProductResp.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
    }
}
