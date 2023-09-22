package kg.drn.drnback.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record RegionResponse(
        String name,
        List<AddressResponse> address
) {
}
