package kg.drn.drnback.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "information_sub_class")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InformationSubClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "information_sub_class_id_gen")
    @SequenceGenerator(name = "information_sub_class_id_gen", sequenceName = "information_sub_class_id_gen", allocationSize = 1)
    Long id;
    String subject;
    String text;
    @ManyToOne
    InformationClass informationClass;
}
