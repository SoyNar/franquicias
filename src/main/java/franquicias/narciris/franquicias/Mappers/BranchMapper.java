package franquicias.narciris.franquicias.Mappers;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.models.Branch;

public class BranchMapper {
    public static Branch toEntity(CommonRequestDto request) {
        Branch branch = new Branch();
        branch.setName(request.getName());
        return branch;
    }

    public static BranchResponseDto toResponse(Branch branch) {
        return BranchResponseDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .build();
    }
}
