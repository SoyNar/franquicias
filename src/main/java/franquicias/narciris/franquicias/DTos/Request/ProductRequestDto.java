package franquicias.narciris.franquicias.DTos.Request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String name;
    private Double stock;

}
