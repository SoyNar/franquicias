package franquicias.narciris.franquicias.services.InterfaceService;

import franquicias.narciris.franquicias.Controllers.BranchController;
import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.models.Branch;

import java.util.List;

public interface BranchInterfaceService {
    BranchResponseDto addBranch(Long branchId,CommonRequestDto requestDto);
    BranchResponseDto updateBranchName(BranchRequestDto requestDto);
    List<BranchResponseDto> getAll();
    BranchResponseDto findById(Long id);
}
