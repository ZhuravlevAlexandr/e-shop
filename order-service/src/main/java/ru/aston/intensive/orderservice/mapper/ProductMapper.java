package ru.aston.intensive.orderservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.orderservice.dto.ProductResp;
import ru.aston.intensive.orderservice.model.entity.Product;


@Mapper
public interface ProductMapper {
    Product toProduct(ProductResp productResp);

    ProductResp toProductResp(Product product);
}
