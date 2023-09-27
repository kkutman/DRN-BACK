package kg.drn.drnback.entity;

import jakarta.persistence.*;
import kg.drn.drnback.entity.enums.EmployeeType;
import kg.drn.drnback.entity.enums.RegionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_gen")
    @SequenceGenerator(name = "employee_id_gen", sequenceName = "employee_id_gen", allocationSize = 1)
    Long id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    String surname;
    String image;
    String email;
    @Column(name = "job_title")
    String jobTitle;
    @Column(name = "phone_number")
    String phoneNumber;
    String address;
    @Enumerated(EnumType.STRING)
    RegionType region;
    @Enumerated(EnumType.STRING)
    EmployeeType employeeType;
}
