package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record DefaultRequest(
        String subject,
        String text
) {
}
