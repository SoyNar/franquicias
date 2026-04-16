package franquicias.narciris.franquicias.Controllers;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/{branchId}")
    public ResponseEntity<ProductResponseDto> addProduct (  @PathVariable Long branchId,@RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(branchId,requestDto));
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

        return ResponseEntity.status(HttpStatus.OK).body(productService.updateStock(id, requestDto));
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<ProductResponseDto> updateProductName(
            @PathVariable Long id,
            @RequestBody ProductRequestDto requestDto) {

        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductName(id, requestDto));
    }

    @GetMapping("/top-stock/{franchiseId}")
    public ResponseEntity<List<ProductResponseDto>> getTopProducts(
            @PathVariable Long franchiseId) {

        return ResponseEntity.status(HttpStatus.OK).body(
                productService.getTopStockProductPerBranch(franchiseId)
        );
    }
}