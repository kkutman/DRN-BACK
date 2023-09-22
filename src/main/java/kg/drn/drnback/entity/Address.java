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
@Table(name = "address")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_gen")
    @SequenceGenerator(name = "address_id_gen", sequenceName = "address_id_seq", allocationSize = 1)
    Long id;
    String name;
    String city;
    String address;
    @Column(name = "phone_number")
    String phoneNumber;
    @ManyToOne
    Region region;
}
