package franquicias.narciris.franquicias.DTos.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BranchRequestDto {
    private  String name;
    private Long id;

}
