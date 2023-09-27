package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record AddressResponse(
        Long id,
        String name,
        String city,
        String address,
        String phoneNumber
) {
}
