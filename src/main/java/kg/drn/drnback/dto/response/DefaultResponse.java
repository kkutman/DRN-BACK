package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record DefaultResponse(
        String text,
        String subject
) {
}
