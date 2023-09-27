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
@Table(name = "contacts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_id_gen")
    @SequenceGenerator(name = "contacts_id_gen", sequenceName = "contacts_id_seq", allocationSize = 1)
    Long id;
    String fax;
    String reception;
    String commonDepartment;
    String generalReception;
    String email;
    String pressService;
    String callCentre;
    String twoGISLink;
    SubCategoryType subCategoryType;
}
