package franquicias.narciris.franquicias.services.ServiceImpl;

import franquicias.narciris.franquicias.DTos.Request.ProductRequestDto;
import franquicias.narciris.franquicias.DTos.Response.ProductResponseDto;
import franquicias.narciris.franquicias.Mappers.ProductMapper;
import franquicias.narciris.franquicias.configuration.Custom.EntityNotFoundException;
import franquicias.narciris.franquicias.models.Branch;
import franquicias.narciris.franquicias.models.Product;
import franquicias.narciris.franquicias.repositories.BranchInterfaceRepository;
import franquicias.narciris.franquicias.repositories.ProductInterfaceRepository;
import franquicias.narciris.franquicias.services.InterfaceService.ProductInterfaceService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductInterfaceService {

    private final ProductInterfaceRepository productRepository;
    private final BranchInterfaceRepository branchRepository;

    public ProductServiceImpl(ProductInterfaceRepository productRepository,
                              BranchInterfaceRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto requestDto) {

        Branch branch = branchRepository.findById(requestDto.getBranchId())
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada"));

        Product product = ProductMapper.toEntity(requestDto);
        product.setBranch(branch);

        Product saved = productRepository.save(product);

        return ProductMapper.toResponse(saved);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        productRepository.delete(product);
    }

    // ✅ CORREGIDO
    @Override
    public ProductResponseDto updateStock(Long id, ProductRequestDto requestDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        product.setStock(requestDto.getStock());

        Product updated = productRepository.save(product);

        return ProductMapper.toResponse(updated);
    }

    @Override
    public ProductResponseDto updateProductName(Long id, ProductRequestDto requestDto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        product.setName(requestDto.getName());

        Product updated = productRepository.save(product);

        return ProductMapper.toResponse(updated);
    }

    @Override
    public List<ProductResponseDto> getTopStockProductPerBranch(Long franchiseId) {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .filter(p -> p.getBranch().getFranchise().getId().equals(franchiseId))
                .collect(Collectors.groupingBy(p -> p.getBranch().getId()))
                .values().stream()
                .map(list -> list.stream()
                        .max(Comparator.comparing(Product::getStock))
                        .orElse(null))
                .filter(Objects::nonNull)
                .map(ProductMapper::toResponse)
                .toList();
    }
}