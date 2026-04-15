package franquicias.narciris.franquicias.Mappers;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.models.Franchise;

public class FranchiseMapper {

    public static Franchise toEntity(CommonRequestDto request) {
        Franchise franchise = new Franchise();
        franchise.setName(request.getName());
        return franchise;
    }

    public static FranchiseResponseDto toResponse(Franchise franchise) {
        return FranchiseResponseDto.builder()
                .id(franchise.getId())
                .name(franchise.getName())
                .build();
    }
}
