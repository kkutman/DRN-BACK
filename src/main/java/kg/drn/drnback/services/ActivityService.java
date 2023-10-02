package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.DefaultRequest;
import kg.drn.drnback.dto.response.DefaultResponse;
import kg.drn.drnback.dto.response.SimpleResponse;

public interface ActivityService {
    SimpleResponse saveActivities(DefaultRequest request);
    SimpleResponse updateActivities(DefaultRequest request);
    SimpleResponse deleteActivities();
    DefaultResponse activities();
}
