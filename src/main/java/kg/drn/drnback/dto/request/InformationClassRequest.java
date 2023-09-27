package kg.drn.drnback.dto.request;

import lombok.Builder;

import java.util.List;

@Builder
public record InformationClassRequest(
        String subject,
        List<InformationSubClassRequest>informationSubClassRequests
) {
}
