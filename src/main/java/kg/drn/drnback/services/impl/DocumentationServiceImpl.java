package kg.drn.drnback.services.impl;

import kg.drn.drnback.dto.request.InformationClassRequest;
import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.entity.InformationClass;
import kg.drn.drnback.entity.Pdf;
import kg.drn.drnback.entity.enums.InformationClassType;
import kg.drn.drnback.entity.enums.PdfType;
import kg.drn.drnback.exception.exceptions.NotFoundException;
import kg.drn.drnback.mapper.InformationSubClassMapper;
import kg.drn.drnback.repository.InformationClassRepository;
import kg.drn.drnback.repository.PdfRepository;
import kg.drn.drnback.repository.custom.InformationRepositoryCustom;
import kg.drn.drnback.services.DocumentationService;
import kg.drn.drnback.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentationServiceImpl implements DocumentationService {
    final InformationClassRepository informationClassRepository;
    final InformationRepositoryCustom informationRepositoryCustom;
    final Valid validation;
    final PdfRepository pdfRepository;

    private InformationClass saveMapper(InformationClassRequest request, InformationClassType type) {
        InformationClass informationClass = InformationClass
                .builder()
                .subject(validation.subjectValid(request.subject()))
                .createAt(LocalDate.now())
                .type(type)
                .build();
        informationClass.setInformationSubClasses(new InformationSubClassMapper().dtoToEntity(request.informationSubClassRequests(), informationClass));
        return informationClass;
    }

    private InformationClass updateMapper(InformationClassRequest request, Long id, String message) {
        InformationClass informationClass = informationClassRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format(message + " c id %s не найден!", id)));
        if (request.informationSubClassRequests().size() != 0)
            informationRepositoryCustom.deleteInformationSubClassByIfoId(id);
        informationClass.setInformationSubClasses(new InformationSubClassMapper().dtoToEntity(request.informationSubClassRequests(), informationClass));
        if (request.subject() != null) informationClass.setSubject(request.subject());
        return informationClass;
    }

    @Override
    public SimpleResponse saveLaws(InformationClassRequest request) {
        InformationClass informationClass = saveMapper(request, InformationClassType.LAWS);
        informationClassRepository.save(informationClass);
        log.info("Нормативный правовой акт успешно сохранен!");
        return SimpleResponse.builder().message("Нормативный правовой акт успешно сохранен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateLaws(InformationClassRequest request, Long id) {
        InformationClass informationClass = updateMapper(request, id, "Нормативный правовой акт");
        informationClassRepository.save(informationClass);
        log.info("Нормативный правовой акт успешно обнавлен!");
        return SimpleResponse.builder().message("Нормативный правовой акт успешно обнавлен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteLaws(Long id) {
        informationClassRepository.delete(informationClassRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Нормативный правовой акт c id %s не найден!", id))));
        log.info("Нормативный правовой акт успешно удален!");
        return SimpleResponse.builder().message("Нормативный правовой акт успешно удален!").status(HttpStatus.OK).build();
    }

    @Override
    public List<InformationClassResponse> getAllLaws() {
        return informationRepositoryCustom.getAllInformationClass(InformationClassType.LAWS);
    }

    @Override
    public SimpleResponse saveInformationSecurity(InformationClassRequest request) {
        InformationClass informationClass = saveMapper(request, InformationClassType.INFORMATION_SECURITY);
        informationClassRepository.save(informationClass);
        log.info("Информационная безопасность успешно сохранен!");
        return SimpleResponse.builder().message("Информационная безопасность успешно сохранен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateInformationSecurity(InformationClassRequest request, Long id) {
        InformationClass informationClass = updateMapper(request, id, "Информационная безопасность");
        informationClassRepository.save(informationClass);
        log.info("Информационная безопасность успешно обнавлен!");
        return SimpleResponse.builder().message("Информационная безопасность успешно обнавлен!").status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse deleteInformationSecurity(Long id) {
        informationClassRepository.delete(informationClassRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Информационная безопасность  акт c id %s не найден!", id))));
        log.info("Информационная безопасность успешно удален!");
        return SimpleResponse.builder().message("Информационная безопасность успешно удален!").status(HttpStatus.OK).build();
    }

    @Override
    public List<InformationClassResponse> getAllInformationSecurity() {
        return informationRepositoryCustom.getAllInformationClass(InformationClassType.INFORMATION_SECURITY);
    }

    @Override
    public SimpleResponse saveGovernmentServicesStandards(String pdf) {
        if (pdfRepository.existsByPdfType(PdfType.GOVERNMENT_SERVICE_STANDARDS))
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("PDF уже есть!").build();
        if (pdf.contains(".pdf")) {
            pdfRepository.save(Pdf.builder()
                    .pdf(pdf)
                    .pdfType(PdfType.GOVERNMENT_SERVICE_STANDARDS)
                    .build());
            log.info("PDF успешно сохранен!");
            return SimpleResponse.builder().message("PDF успешно сохранен!").build();
        } else {
            return SimpleResponse.builder().message("Проверьте является ли ваш файл pdf форматом!").status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public SimpleResponse deleteGovernmentServicesStandards() {
        pdfRepository.delete(pdfRepository.findByPdfType(PdfType.GOVERNMENT_SERVICE_STANDARDS)
                .orElseThrow(() -> new NotFoundException("PDF Стандартных гос услуг не сохранен!")));
        log.info("PDF успешно удален!");
        return SimpleResponse.builder().message("PDF успешно удален!").build();
    }

    @Override
    public SimpleResponse saveRegulationsPublicServices(String pdf) {
        if (pdfRepository.existsByPdfType(PdfType.REGULATION_PUBLIC_SERVICE))
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("PDF уже есть!").build();
        if (pdf.contains(".pdf")) {
            pdfRepository.save(Pdf.builder()
                    .pdf(pdf)
                    .pdfType(PdfType.REGULATION_PUBLIC_SERVICE)
                    .build());
            log.info("PDF успешно сохранен!");
            return SimpleResponse.builder().message("PDF успешно сохранен!").build();
        } else {
            return SimpleResponse.builder().message("Проверьте является ли ваш файл pdf форматом!").status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Override
    public SimpleResponse deleteRegulationsPublicServices() {
        pdfRepository.delete(pdfRepository.findByPdfType(PdfType.REGULATION_PUBLIC_SERVICE)
                .orElseThrow(() -> new NotFoundException("PDF Регламентов гос услуг не сохранен!")));
        log.info("PDF успешно удален!");
        return SimpleResponse.builder().message("PDF успешно удален!").build();
    }

    @Override
    public String getPdf(PdfType type) {
        Pdf pdf = pdfRepository.findByPdfType(type)
                .orElseThrow(() -> new NotFoundException("PDF Регламентов гос услуг не сохранен!"));
        return pdf.getPdf();
    }
}
