package franquicias.narciris.franquicias.DTos.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductResponseDto {
    private Long id;
    private String name;
    private Integer stock;
    private Long branchId;
    private String branchName;
}
