package franquicias.narciris.franquicias.services.ServiceImpl;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.Mappers.BranchMapper;
import franquicias.narciris.franquicias.Mappers.FranchiseMapper;
import franquicias.narciris.franquicias.configuration.Custom.EntityNotFoundException;
import franquicias.narciris.franquicias.models.Branch;
import franquicias.narciris.franquicias.models.Franchise;
import franquicias.narciris.franquicias.repositories.BranchInterfaceRepository;
import franquicias.narciris.franquicias.repositories.FranchiseInterfaceRepository;
import franquicias.narciris.franquicias.services.InterfaceService.BranchInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl  implements BranchInterfaceService {
    private final BranchInterfaceRepository branchRepository;
    private final FranchiseInterfaceRepository franchiseRepository;

    public BranchServiceImpl(BranchInterfaceRepository branchRepository,FranchiseInterfaceRepository franchiseRepository) {
        this.branchRepository = branchRepository;
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public BranchResponseDto addBranch(Long branchId,CommonRequestDto requestDto) {

        Franchise franchise = franchiseRepository.findById(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        Branch branch = BranchMapper.toEntity(requestDto);
        branch.setFranchise(franchise);

        Branch saved = branchRepository.save(branch);

        return BranchMapper.toResponse(saved);
    }

    @Override
    public BranchResponseDto updateBranchName(BranchRequestDto requestDto) {

        Branch branch = branchRepository.findById(requestDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada"));

        branch.setName(requestDto.getName());

        Branch updated = branchRepository.save(branch);

        return BranchMapper.toResponse(updated);
    }

    @Override
    public List<BranchResponseDto> getAll() {
        List<Branch> branches = branchRepository.findAll();

        return branches.stream()
                .map(BranchMapper::toResponse)
                .toList();
    }

    @Override
    public BranchResponseDto findById(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        return BranchMapper.toResponse(branch);
    }
}
