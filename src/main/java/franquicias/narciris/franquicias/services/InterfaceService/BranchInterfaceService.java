package franquicias.narciris.franquicias.services.InterfaceService;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;

import java.util.List;

public interface BranchInterfaceService {
    BranchResponseDto addBranch(Long franchiseId, CommonRequestDto requestDto);
    BranchResponseDto updateBranchName(Long branchId,BranchRequestDto requestDto);
    List<BranchResponseDto> getAll();
    BranchResponseDto findById(Long id);
}