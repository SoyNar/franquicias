package franquicias.narciris.franquicias.Controllers;

import franquicias.narciris.franquicias.DTos.Request.ProductRequestDto;
import franquicias.narciris.franquicias.DTos.Response.ProductResponseDto;
import franquicias.narciris.franquicias.services.InterfaceService.ProductInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductController {

    private final ProductInterfaceService productService;

    public ProductController(ProductInterfaceService productService) {
        this.productService = productService;
    }

    // ✅ Crear producto
    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.ok(productService.addProduct(requestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductResponseDto> updateStock(
            @PathVariable Long id,
            @RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.ok(productService.updateStock(id, requestDto));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<ProductResponseDto> updateProductName(
            @PathVariable Long id,
            @RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.ok(productService.updateProductName(id, requestDto));
    }

    @GetMapping("/top-stock/{franchiseId}")
    public ResponseEntity<List<ProductResponseDto>> getTopProducts(
            @PathVariable Long franchiseId) {

        return ResponseEntity.ok(
                productService.getTopStockProductPerBranch(franchiseId)
        );
    }
}