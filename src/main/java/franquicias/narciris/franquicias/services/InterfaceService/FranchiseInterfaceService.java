package franquicias.narciris.franquicias.services.InterfaceService;

import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.models.Franchise;

import java.util.List;

public interface FranchiseInterfaceService {

    FranchiseResponseDto addFranchise(CommonRequestDto franchise);

    Franchise updateFranchiseName(Long id, String newName);
    List<FranchiseResponseDto> getAll();
    FranchiseResponseDto findById (Long id);
}
