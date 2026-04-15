package franquicias.narciris.franquicias.Controllers;

import franquicias.narciris.franquicias.DTos.Request.BranchRequestDto;
import franquicias.narciris.franquicias.DTos.Response.BranchResponseDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.services.ServiceImpl.BranchServiceImpl;
import franquicias.narciris.franquicias.services.ServiceImpl.FranchiseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sucursales")
public class BranchController {


    private  final BranchServiceImpl branchService;


    public BranchController(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }


    @PostMapping
    public ResponseEntity<BranchResponseDto> addBranch(@RequestBody BranchRequestDto requestDto) {

        BranchResponseDto response = branchService.addBranch(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<BranchResponseDto> updateBranchName(@RequestBody BranchRequestDto requestDto) {

        BranchResponseDto response = branchService.updateBranchName(requestDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDto> getById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(branchService.findById(id));
    }
}
