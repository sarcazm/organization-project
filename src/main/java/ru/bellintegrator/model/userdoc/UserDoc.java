package ru.bellintegrator.model.userdoc;

import lombok.Data;
import ru.bellintegrator.model.doc.Doc;
import ru.bellintegrator.model.user.User;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "User_Doc")
@Data
public class UserDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    @Column(name = "doc_number", nullable = false, length = 50)
    private String docNumber;

    @Temporal(TemporalType.DATE)
    Date docDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_id")
    private Doc document;

    public UserDoc() {
    }
}
