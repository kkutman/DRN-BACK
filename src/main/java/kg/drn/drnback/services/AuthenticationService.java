package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.AuthenticateRequest;
import kg.drn.drnback.dto.request.RegisterRequest;
import kg.drn.drnback.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);
}
