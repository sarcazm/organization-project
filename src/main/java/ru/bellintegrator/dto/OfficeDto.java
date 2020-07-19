package ru.bellintegrator.dto;

import ru.bellintegrator.model.office.Office;
import ru.bellintegrator.model.organization.Organization;

public class OfficeDto {

    public Long id;
    public Long orgId;
    public String name;
    public String address;
    public String phone;
    public Boolean isActive;

    public OfficeDto() {
    }

    public OfficeDto(Long id, Long orgId, String name, String address, String phone, Boolean isActive) {
        this.id = id;
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Office fromDto(){
        return new Office(name, address, phone, isActive);
    }

    @Override
    public String toString() {
        return "OfficeDto{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
