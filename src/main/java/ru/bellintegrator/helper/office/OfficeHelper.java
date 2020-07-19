package ru.bellintegrator.helper.office;

import ru.bellintegrator.dto.OfficeDto;
import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.model.office.Office;
import ru.bellintegrator.model.organization.Organization;

import java.util.LinkedHashMap;
import java.util.Map;

public class OfficeHelper {

    public OfficeHelper() {
    }

    public Map<String, String> paramsToMap(OfficeDto dto){
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", dto.name);

        if (dto.address != null){
            params.put("address", dto.address);
        }
        if (dto.phone != null){
            params.put("phone", dto.phone);
        }
        return params;
    }
    public void requiredParametersForUpdateOrSave(OfficeDto dto) throws RuntimeException{
        if (dto.name == null){
            throw new RuntimeException("name is null");
        }
        if (dto.address == null){
            throw new RuntimeException("address is null");
        }
    }



    public Office recordDtoToOrganization(OfficeDto dto, Office office){
        office.setName(dto.name);
        office.setAddress(dto.address);
        if (dto.phone != null){
            office.setPhone(dto.phone);
        }
        if (dto.isActive != null){
            office.setIsActive(dto.isActive);
        }
        return office;
    }

}
