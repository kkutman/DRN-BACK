package kg.drn.drnback.repository;

import kg.drn.drnback.entity.Contacts;
import kg.drn.drnback.entity.enums.SubCategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts,Long> {
    Optional<Contacts>findBySubCategoryType(SubCategoryType subCategoryType);
    boolean existsBySubCategoryType(SubCategoryType subCategoryType);
}
