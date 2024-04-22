package ru.aston.intensive.productservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.productservice.dto.ProductResp;
import ru.aston.intensive.productservice.model.entity.Product;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductResp productResp);

    ProductResp toProductResp(Product product);
}
