package franquicias.narciris.franquicias.DTos.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BranchResponseDto {
    private Long id;
    private String name;
    private Long franchiseId;
}
