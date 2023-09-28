package kg.drn.drnback.services;

import kg.drn.drnback.dto.request.InformationClassRequest;
import kg.drn.drnback.dto.response.InformationClassResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.entity.enums.PdfType;

import java.util.List;

public interface DocumentationService {
    SimpleResponse saveLaws(InformationClassRequest request);

    SimpleResponse updateLaws(InformationClassRequest request, Long id);

    SimpleResponse deleteLaws(Long id);

    List<InformationClassResponse> getAllLaws();

    SimpleResponse saveInformationSecurity(InformationClassRequest request);

    SimpleResponse updateInformationSecurity(InformationClassRequest request, Long id);

    SimpleResponse deleteInformationSecurity(Long id);

    List<InformationClassResponse> getAllInformationSecurity();
    SimpleResponse saveGovernmentServicesStandards(String pdf);
    SimpleResponse deleteGovernmentServicesStandards();
    SimpleResponse saveRegulationsPublicServices(String pdf);
    SimpleResponse deleteRegulationsPublicServices();
    String getPdf(PdfType type);
}
