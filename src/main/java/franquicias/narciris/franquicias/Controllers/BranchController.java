package franquicias.narciris.franquicias.Controllers;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.services.ServiceImpl.BranchServiceImpl;
import franquicias.narciris.franquicias.services.ServiceImpl.FranchiseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sucursales")
public class BranchController {


    private  final BranchServiceImpl branchService;


    public BranchController(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }


    @PostMapping("/franquicias/{franchiseId}/sucursales")
    public ResponseEntity<BranchResponseDto> addBranch(
            @PathVariable Long franchiseId,
            @RequestBody CommonRequestDto requestDto) {

        BranchResponseDto response = branchService.addBranch(franchiseId, requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{branchId}")
    public ResponseEntity<BranchResponseDto> updateBranchName(
            @PathVariable Long branchId,
            @RequestBody CommonRequestDto requestDto) {

        BranchResponseDto response = branchService.updateBranchName(branchId, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BranchResponseDto>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(branchService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(branchService.findById(id));
    }
}
