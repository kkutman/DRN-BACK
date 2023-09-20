package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record StructureResponse(
        String image,
        String text
) {
}
