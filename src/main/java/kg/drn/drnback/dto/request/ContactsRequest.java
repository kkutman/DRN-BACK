package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record ContactsRequest(
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
