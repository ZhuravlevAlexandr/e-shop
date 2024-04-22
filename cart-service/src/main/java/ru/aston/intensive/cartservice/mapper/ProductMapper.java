package ru.aston.intensive.cartservice.mapper;

import org.mapstruct.Mapper;
import ru.aston.intensive.cartservice.dto.ProductResp;
import ru.aston.intensive.cartservice.model.entity.Product;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductResp productResp);

    ProductResp toProductResp(Product product);
}
