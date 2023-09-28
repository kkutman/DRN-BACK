package kg.drn.drnback.mapper;

import kg.drn.drnback.dto.request.InformationSubClassRequest;
import kg.drn.drnback.entity.InformationClass;
import kg.drn.drnback.entity.InformationSubClass;

import java.util.ArrayList;
import java.util.List;

public class InformationSubClassMapper {
    public List<InformationSubClass>dtoToEntity(List<InformationSubClassRequest>requests, InformationClass informationClass){
        List<InformationSubClass> list = new ArrayList<>();
        for (InformationSubClassRequest request : requests) {
            InformationSubClass informationSubClass = InformationSubClass.builder().subject(request.subject()).text(request.text()).build();
            informationSubClass.setInformationClass(informationClass);
            list.add(informationSubClass);
        }
        return list;
    }
}
