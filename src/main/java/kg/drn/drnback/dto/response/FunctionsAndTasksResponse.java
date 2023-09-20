package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record FunctionsAndTasksResponse(
        String subject,
        String text
) {
}
