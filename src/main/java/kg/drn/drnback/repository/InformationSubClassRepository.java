package kg.drn.drnback.repository;

import kg.drn.drnback.entity.InformationSubClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationSubClassRepository extends JpaRepository<InformationSubClass,Long> {
}
