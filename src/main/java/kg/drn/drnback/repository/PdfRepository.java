package kg.drn.drnback.repository;

import kg.drn.drnback.entity.Pdf;
import kg.drn.drnback.entity.enums.PdfType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PdfRepository extends JpaRepository<Pdf,Long> {
    Optional<Pdf>findByPdfType(PdfType pdfType);
    boolean existsByPdfType(PdfType pdfType);
}
