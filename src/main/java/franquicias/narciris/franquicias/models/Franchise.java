package franquicias.narciris.franquicias.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.resilience.annotation.EnableResilientMethods;

import java.util.List;

@Entity
@Table(name = "franchises")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches;
}
