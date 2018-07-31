package ru.bellintegrator.practice.userDocs.model;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;

/**
 * User_Docs
 */
@Entity
@Table(name = "User_Docs")
public class UserDocs {

    @Id
    @SequenceGenerator(name = "SEQ_USER_DOCS", sequenceName = "SEQ_USER_DOCS", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_USER_DOCS", strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;


    /**
     * код документа
     */
    @Column(name = "docCode", length = 50, nullable = false)
    private String docCode;

    /**
     * имя документа
     */
    @Column(name = "docName", length = 50, nullable = false)
    private String docName;

    /**
     * номер документа
     */
    @Column(name = "docNumber", nullable = false)
    private String docNumber;

    /**
     * дата создания документа
     */
    @Column(name = "docDate", length = 50, nullable = false)
    private String docDate;

    @OneToOne(mappedBy = "userDocs")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDocs() {
    }

    public UserDocs(String docCode, String docName, String docNumber, String docDate) {
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;

    }
    public UserDocs(Long id,String docCode, String docName, String docNumber, String docDate) {
        this.id=id;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }




    @Override
    public String toString() {
        return "UserDocs{" +
                "id=" + id +
                ", docCode='" + docCode + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                '}';
    }
}
