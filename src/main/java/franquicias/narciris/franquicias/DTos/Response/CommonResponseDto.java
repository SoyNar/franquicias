package franquicias.narciris.franquicias.DTos.Response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CommonResponseDto {
    private Long id;
    private String name;

}
