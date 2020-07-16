package ru.bellintegrator.model.office;

import lombok.Data;
import ru.bellintegrator.model.organization.Organization;
import ru.bellintegrator.model.user.User;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Office")
@Data
public class Office {

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
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;
    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<User> users = new ArrayList<>();

    public Office() {
    }

    @Override
    public String toString() {
        return "Office{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                ", organization=" + organization +
                '}';
    }
}
