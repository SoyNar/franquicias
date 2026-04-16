package franquicias.narciris.franquicias.DTos.Request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchRequestDto {
    private  String name;
    private Long id;

}
