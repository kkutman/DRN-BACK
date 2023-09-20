package kg.drn.drnback.entity;

import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.SubCategoryType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "text")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "text_id_gen")
    @SequenceGenerator(name = "text_id_gen", sequenceName = "text_id_gen", allocationSize = 1)
    Long id;
    String image;
    String subject;
    String text;
    @Enumerated(EnumType.STRING)
    SubCategoryType subCategoryType;
}
