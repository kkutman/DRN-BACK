package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.InformationClassRequest;
import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / ПОЛОЖЕНИЯ API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionApi {
    final AboutTheDepartmentService service;
    @Operation(summary = "Сохранение положения", description = "Этот метод для сохранение положения!")
    @PostMapping("/save_position")
    public SimpleResponse savePosition(@RequestBody InformationClassRequest request) {
        return service.saveNPA(request);
    }

    @Operation(summary = "Положения", description = "Этот метод для положения!")
    @GetMapping("/get_position")
    public List<InformationClassResponse> getAllPosition() {
        return service.getAllNPA();
    }

    @Operation(summary = "Удаления положения", description = "Этот метод для удаления положения!")
    @DeleteMapping("/delete_position")
    public SimpleResponse deletePosition(Long id) {
        return service.deleteNPA(id);
    }

    @Operation(summary = "Редактирование положения", description = "Этот метод для редактирование положения!")
    @PostMapping("/update_position")
    public SimpleResponse updatePosition(@RequestParam Long id, @RequestBody InformationClassRequest request) {
        return service.updateNPA(request, id);
    }
}
