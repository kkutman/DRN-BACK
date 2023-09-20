package kg.drn.drnback.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.services.AboutUsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/about_us")
@RequiredArgsConstructor
@Tag(name = "О НАС API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutUs {
    final AboutUsService aboutUsService;

}
