package kg.drn.drnback.repository;

import kg.drn.drnback.entity.Text;
import kg.drn.drnback.entity.enums.SubCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TextRepository extends JpaRepository<Text,Long> {
    Optional<Text>findBySubCategoryType(SubCategoryType subCategoryType);
    boolean existsBySubCategoryType(SubCategoryType subCategoryType);
}
