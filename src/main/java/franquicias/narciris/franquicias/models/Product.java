package franquicias.narciris.franquicias.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double stock;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
