package kg.drn.drnback.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.HistoryRequest;
import kg.drn.drnback.dto.response.HistoryResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/about_us")
@RequiredArgsConstructor
@Tag(name = "О НАС API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutUs {
    final AboutTheDepartmentService service;
    @Operation(summary = "Сохранение историй", description = "Этот метод для сохранение историй!")
    @PostMapping("/save_history")
    public SimpleResponse saveHistory(HistoryRequest request){
        return service.saveHistory(request);
    }
    public SimpleResponse updateHistory(HistoryRequest request) {
        return null;
    }
    public SimpleResponse deleteHistory() {
        return null;
    }


    public HistoryResponse history() {
        return null;
    }

}
