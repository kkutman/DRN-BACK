package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record EmployeeResponse(
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
