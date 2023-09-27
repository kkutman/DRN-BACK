package kg.drn.drnback.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.drn.drnback.entity.Region;
import kg.drn.drnback.entity.enums.RegionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse{
    String firstName;
    String lastName;
    String surname;
    String image;
    String email;
    String jobTitle;
    String phoneNumber;
    String address;
    RegionType region;
}
