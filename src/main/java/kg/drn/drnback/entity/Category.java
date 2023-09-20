package kg.drn.drnback.entity;
import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.CategoryType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_gen")
    @SequenceGenerator(name = "category_id_gen", sequenceName = "category_id_seq", allocationSize = 1)
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    CategoryType categoryType;

    @OneToMany(mappedBy = "category")
    List<SubCategory> subCategory;

}
