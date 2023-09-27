package kg.drn.drnback.dto.request;

import lombok.Builder;

@Builder
public record InformationSubClassRequest(
        String subject,
        String text
) {
}
