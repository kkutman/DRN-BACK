package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record StructureRequest(
        String image,
        String text
) {
}
