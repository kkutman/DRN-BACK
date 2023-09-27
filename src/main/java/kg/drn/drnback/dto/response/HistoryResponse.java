package kg.drn.drnback.dto.response;

import lombok.Builder;

@Builder
public record HistoryResponse(
        String history,
        String subject
) {
}
