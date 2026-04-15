package franquicias.narciris.franquicias.services.InterfaceService;

import franquicias.narciris.franquicias.DTos.Request.ProductRequestDto;
import franquicias.narciris.franquicias.DTos.Response.ProductResponseDto;
import franquicias.narciris.franquicias.models.Product;

import java.util.List;

public interface ProductInterfaceService {
    ProductResponseDto addProduct(Long branchId,ProductRequestDto requestDto);
    void deleteProduct(Long productId);
    ProductResponseDto updateStock(Long id, ProductRequestDto requestDto);
    ProductResponseDto updateProductName(Long id, ProductRequestDto requestDto);
    List<ProductResponseDto> getTopStockProductPerBranch(Long franchiseId);
}
