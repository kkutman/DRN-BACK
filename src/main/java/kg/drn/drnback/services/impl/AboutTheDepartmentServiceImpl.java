package kg.drn.drnback.services.impl;

import kg.drn.drnback.dto.request.*;
import kg.drn.drnback.dto.response.*;
import kg.drn.drnback.entity.Text;
import kg.drn.drnback.entity.enums.SubCategoryType;
import kg.drn.drnback.repository.TextRepository;
import kg.drn.drnback.services.AboutTheDepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutTheDepartmentServiceImpl implements AboutTheDepartmentService {
    final TextRepository textRepository;

    @Override
    public SimpleResponse saveHistory(HistoryRequest request) {
        textRepository.save(Text.builder()
                .subject(request.subject())
                .text(request.text())
                .subCategoryType(SubCategoryType.valueOf(request.subCategoryType())).build());
        return SimpleResponse.builder().message("History successfully saved!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateHistory(HistoryRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteHistory() {
        return null;
    }

    @Override
    public HistoryResponse history() {
        return null;
    }

    @Override
    public SimpleResponse saveEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteEmployee(Long id) {
        return null;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return null;
    }

    @Override
    public SimpleResponse saveStructure(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateStructure(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteStructure() {
        return null;
    }

    @Override
    public StructureResponse structure() {
        return null;
    }

    @Override
    public SimpleResponse saveSymbolism(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateSymbolism(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteSymbolism() {
        return null;
    }

    @Override
    public SymbolismResponse symbolism() {
        return null;
    }

    @Override
    public SimpleResponse saveContact(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateContact(StructureRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteContact() {
        return null;
    }

    @Override
    public ContactsResponse contact() {
        return null;
    }

    @Override
    public SimpleResponse saveAddress(AddressRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateAddress(AddressRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteAddress(AddressRequest request) {
        return null;
    }

    @Override
    public RegionResponse region(Long id) {
        return null;
    }

    @Override
    public SimpleResponse saveNPA(DefaultRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateNPA(DefaultRequest request, Long id) {
        return null;
    }

    @Override
    public SimpleResponse deleteNPA(Long id) {
        return null;
    }

    @Override
    public List<InformationClassResponse> getAllNPA() {
        return null;
    }
}
