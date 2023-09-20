package kg.drn.drnback.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sub_category_id_gen")
    @SequenceGenerator(name = "sub_category_id_gen", sequenceName = "sub_category_id_seq", allocationSize = 1)
    Long id;

    String name;

    @ManyToOne
    Category category;
}
