package franquicias.narciris.franquicias.services.InterfaceService;

import franquicias.narciris.franquicias.models.Product;

import java.util.List;

public interface ProductInterfaceService {
    Product addProduct(Long branchId, Product product);
    void deleteProduct(Long productId);
    Product updateStock(Long productId, Integer newStock);
    Product updateProductName(Long productId, String newName);
    List<Product> getTopStockProductPerBranch(Long franchiseId);
}
