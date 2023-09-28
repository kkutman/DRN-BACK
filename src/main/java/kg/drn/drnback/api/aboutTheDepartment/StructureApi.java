package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.StructureRequest;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.dto.response.StructureResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/structure")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / СТРУКТУРА API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StructureApi {
    final AboutTheDepartmentService service;
    @Operation(summary = "Сохранение структуры", description = "Этот метод для сохранение структуры!")
    @PostMapping("/save_structure")
    public SimpleResponse saveStructure(@RequestBody StructureRequest request) {
        return service.saveStructure(request);
    }

    @Operation(summary = "Редактирование структуры", description = "Этот метод для редактирование структуры!")
    @PostMapping("/update_structure")
    public SimpleResponse updateStructure(@RequestBody StructureRequest request) {
        return service.updateStructure(request);
    }

    @Operation(summary = "Удаления структуры", description = "Этот метод для удаления структуры!")
    @DeleteMapping("/delete_structure")
    public SimpleResponse deleteStructure() {
        return service.deleteStructure();
    }

    @Operation(summary = "Структура", description = "Этот метод для структуры!")
    @GetMapping("/get_structure")
    public StructureResponse structure() {
        return service.structure();
    }

}
