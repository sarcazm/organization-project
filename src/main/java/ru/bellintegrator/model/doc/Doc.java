package ru.bellintegrator.model.doc;

import lombok.Data;
import ru.bellintegrator.model.userdoc.UserDoc;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Doc")
@Data
public class Doc {
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

    @OneToMany(mappedBy = "document", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserDoc> userDocs = new ArrayList<>();
}
