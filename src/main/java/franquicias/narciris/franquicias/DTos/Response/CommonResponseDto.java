package franquicias.narciris.franquicias.DTos.Response;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponseDto {
    private Long id;
    private String name;

}
