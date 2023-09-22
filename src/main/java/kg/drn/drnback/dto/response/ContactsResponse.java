package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record ContactsResponse(
        String fax,
        String reception,
        String commonDepartment,
        String generalReception,
        String email,
        String pressService,
        String callCentre,
        String twoGISLink
) {
}
