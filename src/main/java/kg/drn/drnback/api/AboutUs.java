package kg.drn.drnback.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.drn.drnback.dto.request.*;
import kg.drn.drnback.dto.response.*;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SimpleResponse saveHistory(@RequestBody HistoryRequest request) {
        return service.saveHistory(request);
    }

    @Operation(summary = "Редактирование историй", description = "Этот метод для редактирование историй!")
    @PostMapping("/update_history")
    public SimpleResponse updateHistory(@RequestBody HistoryRequest request) {
        return service.updateHistory(request);
    }

    @Operation(summary = "Удаления историй", description = "Этот метод для удаления историй!")
    @DeleteMapping("/delete_history")
    public SimpleResponse deleteHistory() {
        return service.deleteHistory();
    }

    @Operation(summary = "История", description = "Этот метод для историй!")
    @GetMapping("/get_history")
    public HistoryResponse history() {
        return service.history();
    }


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


    @Operation(summary = "Сохранение контакта", description = "Этот метод для сохранение контакта!")
    @PostMapping("/save_contact")
    public SimpleResponse saveContact(@RequestBody ContactsRequest request) {
        return service.saveContact(request);
    }

    @Operation(summary = "Редактирование контакта", description = "Этот метод для редактирование контакта!")
    @PostMapping("/update_contact")
    public SimpleResponse updateContact(@RequestBody ContactsRequest request) {
        return service.updateContact(request);
    }

    @Operation(summary = "Удаления контакта", description = "Этот метод для удаления контакта!")
    @DeleteMapping("/delete_contact")
    public SimpleResponse deleteContact() {
        return service.deleteContact();
    }

    @Operation(summary = "Контакт", description = "Этот метод для контакта!")
    @GetMapping("/get_contact")
    public ContactsResponse contact() {
        return service.contact();
    }


    @Operation(summary = "Сохранение адреса", description = "Этот метод для сохранение адреса!")
    @PostMapping("/save_address")
    public SimpleResponse saveAddress(AddressRequest request) {
        return service.saveAddress(request);
    }

    @Operation(summary = "Редактирование адреса", description = "Этот метод для редактирование адреса!")
    @PostMapping("/update_address")
    public SimpleResponse updateAddress(Long addressId, AddressRequest request) {
        return service.updateAddress(request, addressId);
    }

    @Operation(summary = "Удаления адреса", description = "Этот метод для удаления адреса!")
    @DeleteMapping("/delete_address")
    public SimpleResponse deleteAddress(Long id) {
        return service.deleteAddress(id);
    }

    @Operation(summary = "Адрес", description = "Этот метод для адреса!")
    @GetMapping("/get_address")
    public RegionResponse region(Long id) {
        return service.region(id);
    }


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
