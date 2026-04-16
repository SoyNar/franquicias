package franquicias.narciris.franquicias.services.ServiceImpl;

import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.Mappers.FranchiseMapper;
import franquicias.narciris.franquicias.configuration.Custom.EntityNotFoundException;
import franquicias.narciris.franquicias.models.Franchise;
import franquicias.narciris.franquicias.repositories.FranchiseInterfaceRepository;
import franquicias.narciris.franquicias.services.InterfaceService.FranchiseInterfaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranchiseServiceImpl  implements FranchiseInterfaceService {

    private final FranchiseInterfaceRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseInterfaceRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public FranchiseResponseDto addFranchise(CommonRequestDto request) {

        Franchise franchise = FranchiseMapper.toEntity(request);
        Franchise saved = franchiseRepository.save(franchise);

        return FranchiseMapper.toResponse(saved);
    }

    @Override
    public Franchise updateFranchiseName(Long id, String newName) {

        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Franchise no encontrada"));

        franchise.setName(newName);

        return franchiseRepository.save(franchise);
    }

    @Override
    public List<FranchiseResponseDto> getAll() {

        List<Franchise> franchises = franchiseRepository.findAll();

        return franchises.stream()
                .map(FranchiseMapper::toResponse)
                .toList();
    }

    @Override
    public FranchiseResponseDto findById(Long id) {

        Franchise franchise = franchiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        return FranchiseMapper.toResponse(franchise);
    }
}
