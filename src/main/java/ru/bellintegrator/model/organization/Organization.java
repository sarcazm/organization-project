package ru.bellintegrator.model.organization;

import lombok.Data;
import ru.bellintegrator.model.office.Office;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Organization")
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;
    @Column(name = "inn", nullable = false, length = 10)
    private String inn;
    @Column(name = "kpp", nullable = false, length = 9)
    private String kpp;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices = new ArrayList<>();


    public Organization() {
    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
