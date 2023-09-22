package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record AddressRequest(
        String name,
        String city,
        String address,
        String phoneNumber,
        Long regionId
) {
}
