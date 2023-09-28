package kg.drn.drnback.entity;

import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.PdfType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pdf")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pdf {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pdf_id_gen")
    @SequenceGenerator(name = "pdf_id_gen", sequenceName = "pdf_id_gen", allocationSize = 1)
    Long id;
    String pdf;
    @Enumerated(EnumType.STRING)
    PdfType pdfType;
}
