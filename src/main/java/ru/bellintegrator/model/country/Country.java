package ru.bellintegrator.model.country;

import lombok.Data;
import ru.bellintegrator.model.user.User;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Country")
@Data
public class Country {
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
    @Column(name = "code", nullable = false, length = 50)
    private String code;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

    public Country() {
    }
}
