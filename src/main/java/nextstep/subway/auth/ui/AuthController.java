package nextstep.subway.auth.ui;

import lombok.extern.slf4j.Slf4j;
import nextstep.subway.auth.application.AuthService;
import nextstep.subway.auth.dto.TokenRequest;
import nextstep.subway.auth.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "file")
@RestController
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/token")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest request) {
        TokenResponse token = authService.login(request);
        log.info("[LOGIN] {} => login 및 accessToken 발급 성공.", request.getEmail());
        return ResponseEntity.ok().body(token);
    }
}
