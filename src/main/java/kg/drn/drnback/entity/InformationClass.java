package kg.drn.drnback.entity;

import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.InformationClassType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "information_class")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InformationClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "information_class_id_gen")
    @SequenceGenerator(name = "information_class_id_gen", sequenceName = "information_class_id_gen", allocationSize = 1)
    Long id;
    String subject;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "informationClass")
    List<InformationSubClass>informationSubClasses;
    @Enumerated(EnumType.STRING)
    InformationClassType type;
    LocalDate createAt;


}