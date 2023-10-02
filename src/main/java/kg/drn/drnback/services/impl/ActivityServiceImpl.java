package kg.drn.drnback.services.impl;

import kg.drn.drnback.dto.request.DefaultRequest;
import kg.drn.drnback.dto.response.DefaultResponse;
import kg.drn.drnback.dto.response.SimpleResponse;
import kg.drn.drnback.entity.Text;
import kg.drn.drnback.entity.enums.SubCategoryType;
import kg.drn.drnback.repository.TextRepository;
import kg.drn.drnback.services.ActivityService;
import kg.drn.drnback.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    final TextRepository textRepository;
    final Valid validation;
    @Override
    public SimpleResponse saveActivities(DefaultRequest request) {
        if (textRepository.existsBySubCategoryType(SubCategoryType.ACTIVITIES)) {
            return SimpleResponse.builder().status(HttpStatus.BAD_REQUEST).message("История уже есть!").build();
        }
        textRepository.save(Text.builder()
                .subject(validation.subjectValid(request.subject()))
                .text(validation.textValid(request.text()))
                .subCategoryType(SubCategoryType.ACTIVITIES)
                .build());
        log.info("Направления деятельности успешно сохранена!");
        return SimpleResponse.builder().message("Направления деятельности успешно сохранена!")
                .status(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateActivities(DefaultRequest request) {
        return null;
    }

    @Override
    public SimpleResponse deleteActivities() {
        return null;
    }

    @Override
    public DefaultResponse activities() {
        return null;
    }
}
