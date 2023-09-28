package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.SymbolismRequest;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.dto.response.SymbolismResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/symbolism")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / СИМВОЛИКА API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SymbolismApi {
    final AboutTheDepartmentService service;

    @Operation(summary = "Сохранение символики", description = "Этот метод для сохранение символики!")
    @PostMapping("/save_symbolism")
    public SimpleResponse saveSymbolism(@RequestBody SymbolismRequest request) {
        return service.saveSymbolism(request);
    }

    @Operation(summary = "Редактирование символики", description = "Этот метод для редактирование символики!")
    @PostMapping("/update_symbolism")
    public SimpleResponse updateSymbolism(@RequestBody SymbolismRequest request) {
        return service.updateSymbolism(request);
    }

    @Operation(summary = "Удаления символики", description = "Этот метод для удаления символики!")
    @DeleteMapping("/delete_symbolism")
    public SimpleResponse deleteSymbolism() {
        return service.deleteSymbolism();
    }

    @Operation(summary = "Символики", description = "Этот метод для символики!")
    @GetMapping("/get_symbolism")
    public SymbolismResponse symbolism() {
        return service.symbolism();
    }

}
