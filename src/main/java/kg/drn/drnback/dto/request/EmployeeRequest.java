package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record EmployeeRequest(
        String firstName,
        String lastName,
        String surname,
        String image,
        String email,
        String jobTitle,
        String phoneNumber,
        String address,
        String region
) {
}
