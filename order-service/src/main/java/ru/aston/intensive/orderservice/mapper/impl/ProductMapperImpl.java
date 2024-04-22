package ru.aston.intensive.orderservice.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aston.intensive.orderservice.dto.ProductResp;
import ru.aston.intensive.orderservice.mapper.ProductMapper;
import ru.aston.intensive.orderservice.model.entity.Product;


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
