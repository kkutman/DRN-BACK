package kg.drn.drnback.api.aboutTheDepartment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.EmployeeRequest;
import kg.drn.drnback.dto.response.EmployeeResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Tag(name = "О ДЕПАРТАМЕНТЕ / РУКОВОДСТВА API")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeApi {
    final AboutTheDepartmentService service;
    @Operation(summary = "Сохранение работника", description = "Этот метод для сохранение работника!")
    @PostMapping("/save_employee")
    public SimpleResponse saveEmployee(@RequestBody EmployeeRequest request) {
        return service.saveEmployee(request);
    }

    @Operation(summary = "Редактирование работника", description = "Этот метод для редактирование работника!")
    @PostMapping("/update_employee")
    public SimpleResponse updateEmployee(@RequestBody EmployeeRequest request, @RequestParam Long employeeId) {
        return service.updateEmployee(request, employeeId);
    }

    @Operation(summary = "Удаления работника", description = "Этот метод для удаления работника!")
    @DeleteMapping("/delete_employee")
    public SimpleResponse deleteEmployee(@RequestParam Long employeeId) {
        return service.deleteEmployee(employeeId);
    }

    @Operation(summary = "Все работники", description = "Этот метод для ввыода всех работников!")
    @GetMapping("/get_all_employee")
    public List<EmployeeResponse> getAllEmployee() {
        return service.getAllEmployee();
    }

}
