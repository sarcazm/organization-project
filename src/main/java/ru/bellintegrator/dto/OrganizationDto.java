package ru.bellintegrator.dto;

import ru.bellintegrator.model.organization.Organization;

public class OrganizationDto {
    public Long id;
    public String name;
    public String fullName;
    public String inn;
    public String kpp;
    public String address;
    public String phone;
    public Boolean isActive;



    public OrganizationDto() {
    }


    public OrganizationDto(Long id, String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Organization fromDto(){
        return new Organization(name, fullName, inn, kpp, address, phone, isActive);
    }

    public static OrganizationDto toDto(Organization organization){
        return new OrganizationDto(organization.getId(), organization.getName(), organization.getFullName(), organization.getInn(), organization.getKpp(),
                organization.getAddress(), organization.getPhone(), organization.getIsActive());
    }

    @Override
    public String toString() {
        return "OrganizationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
