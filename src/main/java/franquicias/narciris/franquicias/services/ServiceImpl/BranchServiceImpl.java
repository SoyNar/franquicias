package franquicias.narciris.franquicias.services.ServiceImpl;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.models.Branch;
import franquicias.narciris.franquicias.models.Franchise;
import franquicias.narciris.franquicias.repositories.BranchInterfaceRepository;
import franquicias.narciris.franquicias.repositories.FranchiseInterfaceRepository;
import franquicias.narciris.franquicias.services.InterfaceService.BranchInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchInterfaceService {

    private final BranchInterfaceRepository branchRepository;
    private final FranchiseInterfaceRepository franchiseRepository;

    public BranchServiceImpl(BranchInterfaceRepository branchRepository,
                             FranchiseInterfaceRepository franchiseRepository) {
        this.branchRepository = branchRepository;
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public BranchResponseDto addBranch(Long franchiseId, CommonRequestDto requestDto) {
        Franchise franchise = franchiseRepository.findById(franchiseId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Branch branch = Branch.builder()
                .name(requestDto.getName())
                .franchise(franchise)
                .build();

        Branch saved = branchRepository.save(branch);

        return BranchResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .franchiseId(saved.getFranchise().getId())
                .build();
    }

    @Override
    public BranchResponseDto updateBranchName(Long branchId, CommonRequestDto requestDto) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        branch.setName(requestDto.getName());
        Branch saved = branchRepository.save(branch);

        return BranchResponseDto.builder()
                .id(saved.getId())
                .name(saved.getName())
                .franchiseId(saved.getFranchise().getId())
                .build();
    }

    @Override
    public List<BranchResponseDto> getAll() {
        return branchRepository.findAll().stream()
                .map(branch -> BranchResponseDto.builder()
                        .id(branch.getId())
                        .name(branch.getName())
                        .franchiseId(branch.getFranchise().getId())
                        .build())
                .toList();
    }

    @Override
    public BranchResponseDto findById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        return BranchResponseDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .franchiseId(branch.getFranchise().getId())
                .build();
    }
}