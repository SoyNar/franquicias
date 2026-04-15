package franquicias.narciris.franquicias.Controllers;

import franquicias.narciris.franquicias.DTos.Request.CommonRequestDto;
import franquicias.narciris.franquicias.DTos.Response.FranchiseResponseDto;
import franquicias.narciris.franquicias.Mappers.FranchiseMapper;
import franquicias.narciris.franquicias.models.Franchise;
import franquicias.narciris.franquicias.services.ServiceImpl.FranchiseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/franquicias")
public class FranchiseController {

    private  final FranchiseServiceImpl franchiseService;

    public FranchiseController(FranchiseServiceImpl franchiseService) {
        this.franchiseService = franchiseService;
    }


//    public FranchiseController(private)

    @PostMapping("/")
    public ResponseEntity<FranchiseResponseDto> addFranchise(@RequestBody CommonRequestDto request) {
        FranchiseResponseDto response = franchiseService.addFranchise(request);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FranchiseResponseDto> updateFranchiseName(
            @PathVariable Long id,
            @RequestBody CommonRequestDto request) {

        Franchise updated = franchiseService.updateFranchiseName(id, request.getName());

        return ResponseEntity.ok(FranchiseMapper.toResponse(updated));
    }
    @GetMapping
    public ResponseEntity<List<FranchiseResponseDto>> getAllFranchises() {

        return ResponseEntity.status(HttpStatus.OK).body(franchiseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranchiseResponseDto> getFranchiseById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(franchiseService.findById(id));
    }
}
