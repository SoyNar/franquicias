package franquicias.narciris.franquicias.Mappers;

import franquicias.narciris.franquicias.DTos.Request.ProductRequestDto;
import franquicias.narciris.franquicias.DTos.Response.ProductResponseDto;
import franquicias.narciris.franquicias.models.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDto request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setStock(request.getStock());
        return product;
    }

    public static ProductResponseDto toResponse(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .branchId(product.getBranch().getId())
                .branchName(product.getBranch().getName())
                .build();
    }
}
