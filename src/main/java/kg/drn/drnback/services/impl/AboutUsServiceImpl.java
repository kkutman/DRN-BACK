package kg.drn.drnback.services.impl;

import kg.drn.drnback.dto.request.DefaultRequest;
import kg.drn.drnback.dto.request.EmployeeRequest;
import kg.drn.drnback.dto.request.HistoryRequest;
import kg.drn.drnback.dto.request.StructureRequest;
import kg.drn.drnback.dto.response.*;
import kg.drn.drnback.repository.TextRepository;
import kg.drn.drnback.services.AboutUsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AboutUsServiceImpl implements AboutUsService {
    final TextRepository textRepository;

    @Override
    public SimpleResponse saveHistory(HistoryRequest request) {
        return null;
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
    public SimpleResponse saveFunctionsAndTasks(DefaultRequest request) {
        return null;
    }

    @Override
    public SimpleResponse updateFunctionsAndTasks(DefaultRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteFunctionsAndTasks() {
        return null;
    }

    @Override
    public FunctionsAndTasksResponse functionsAndTasks() {
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
}
