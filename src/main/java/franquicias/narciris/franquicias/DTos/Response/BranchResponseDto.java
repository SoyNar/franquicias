package franquicias.narciris.franquicias.DTos.Response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponseDto {
    private Long id;
    private String name;
    private Long franchiseId;
}
