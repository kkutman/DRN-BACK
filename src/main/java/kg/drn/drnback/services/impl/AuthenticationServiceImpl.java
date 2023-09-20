package kg.drn.drnback.services.impl;


import kg.drn.drnback.config.jwt.JwtService;
import kg.drn.drnback.dto.request.AuthenticateRequest;
import kg.drn.drnback.dto.request.RegisterRequest;
import kg.drn.drnback.dto.response.AuthenticationResponse;
import kg.drn.drnback.entity.User;
import kg.drn.drnback.entity.enums.Role;
import kg.drn.drnback.exception.exceptions.BadCredentialException;
import kg.drn.drnback.exception.exceptions.BadRequestException;
import kg.drn.drnback.repository.UserRepository;
import kg.drn.drnback.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.name())
                .role(Role.ADMIN)
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        userRepository.save(user);
        log.info(String.format("Пользователь %s успешно сохранен!", user.getEmail()));

        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        User userInfo = userRepository.findByEmail(request.email())
                .orElseThrow(() -> {
                    log.error(String.format("Админ с адресом электронной почты %s не существует", request.email()));
                    return new BadCredentialException(String.format("Админ с адресом электронной почты %s не существует", request.email()));
                });
        if (!passwordEncoder.matches(request.password(), userInfo.getPassword())) {
            log.error("Пароль не подходит");
            throw new BadRequestException("Пароль не подходит");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        log.info(String.format("Админ %s успешно аутентифицирован", userInfo.getEmail()));
        String token = jwtService.generateToken(userInfo);

        return AuthenticationResponse.builder()
                .email(userInfo.getEmail())
                .role(userInfo.getRole())
                .token(token)
                .build();
    }
}
