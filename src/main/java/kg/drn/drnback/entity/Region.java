package kg.drn.drnback.entity;

import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.RegionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "region")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_id_gen")
    @SequenceGenerator(name = "region_id_gen", sequenceName = "region_id_gen", allocationSize = 1)
    Long id;
    @Column(name = "region_name")
    String regionName;
    @Enumerated(EnumType.STRING)
    RegionType regionType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "region")
    List<Address>addresses;
}
