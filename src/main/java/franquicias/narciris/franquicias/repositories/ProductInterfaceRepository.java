package franquicias.narciris.franquicias.repositories;

import franquicias.narciris.franquicias.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductInterfaceRepository extends JpaRepository<Product,Long> {
    @Query("""
        SELECT p FROM Product p
        WHERE p.branch.franchise.id = :franchiseId
        AND p.stock = (
            SELECT MAX(p2.stock) FROM Product p2
            WHERE p2.branch = p.branch
        )
    """)
    List<Product> findTopStockProductPerBranch(Long franchiseId);
}
