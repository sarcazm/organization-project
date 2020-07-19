package ru.bellintegrator.helper.organization;

import ru.bellintegrator.dto.OrganizationDto;
import ru.bellintegrator.model.organization.Organization;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizationHelper {

    public Map<String, String> paramsToMap(OrganizationDto dto){
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", dto.name);

        if (dto.address != null){
            params.put("address", dto.address);
        }
        if (dto.fullName != null){
            params.put("full_name", dto.fullName);
        }
        if (dto.inn != null){
            params.put("inn", dto.inn);
        }
        if (dto.kpp != null){
            params.put("kpp", dto.kpp);
        }
        if (dto.phone != null){
            params.put("phone", dto.phone);
        }
        return params;
    }
    public void requiredParametersForUpdateOrSave(OrganizationDto dto) throws RuntimeException{
        if (dto.name == null){
            throw new RuntimeException("name is null");
        }
        if (dto.fullName == null){
            throw new RuntimeException("fullName is null");
        }
        if (dto.inn == null){
            throw new RuntimeException("inn is null");
        }
        if (dto.kpp == null){
            throw new RuntimeException("kpp is null");
        }
        if (dto.address == null){
            throw new RuntimeException("address is null");
        }
    }



    public Organization recordDtoToOrganization(OrganizationDto dto, Organization organization){
        organization.setName(dto.name);
        organization.setFullName(dto.fullName);
        organization.setInn(dto.inn);
        organization.setKpp(dto.kpp);
        organization.setAddress(dto.address);
        if (dto.phone != null){
            organization.setPhone(dto.phone);
        }
        if (dto.isActive != null){
            organization.setIsActive(dto.isActive);
        }
        return organization;
    }

}
