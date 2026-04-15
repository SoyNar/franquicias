package franquicias.narciris.franquicias.DTos.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequestDto {

    private String name;
    private Double stock;

}
