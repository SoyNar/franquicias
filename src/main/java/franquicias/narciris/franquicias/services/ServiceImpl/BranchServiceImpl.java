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
import franquicias.narciris.franquicias.services.InterfaceService.BranchInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl  implements BranchInterfaceService {
    private final BranchInterfaceRepository branchRepository;

    public BranchServiceImpl(BranchInterfaceRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchResponseDto addBranch(BranchRequestDto requestDto) {

        Branch branch = BranchMapper.toEntity(requestDto);

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
