package kg.drn.drnback.dto.request;


import lombok.Builder;

@Builder
public record HistoryRequest(
        String text,
        String subject
) {
}
