package kg.drn.drnback.repository;

import kg.drn.drnback.entity.InformationClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationClassRepository extends JpaRepository<InformationClass,Long> {
}
