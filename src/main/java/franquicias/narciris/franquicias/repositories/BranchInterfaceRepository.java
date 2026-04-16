package franquicias.narciris.franquicias.repositories;

import franquicias.narciris.franquicias.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchInterfaceRepository extends JpaRepository<Branch,Long> {
}
