package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.house.model.House;
import ru.bellintegrator.practice.userDocs.model.UserDocs;

import javax.persistence.*;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User_Bell")
public class User {

    @Id
    @SequenceGenerator(name = "SEQ_USER_BELL", sequenceName = "SEQ_USER_BELL", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_USER_BELL", strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;


    /**
     * Первое имя
     */
    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    /**
     * secondName
     */
    @Column(name = "secondName", length = 50, nullable = false)
    private String secondName;

    /**
     * middleName
     */
    @Column(name = "middleName", length = 50, nullable = false)
    private String middleName;

    /**
     * должность
     */
    @Column(name = "position", length = 50, nullable = false)
    private String position;

    /**
     * телефон
     */
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * гражданство
     */
    @Column(name = "citizenshipName", length = 50, nullable = false)
    private String citizenshipName;

    /**
     * код города
     */
    @Column(name = "citizenshipCode", length = 50, nullable = false)
    private String citizenshipCode;

    /**
     * id офиса
     */
    @Column(name = "officeId", length = 50, nullable = false)
    private Long officeId;

    /**
     * Состояние
     */
    @Column(name = "isIdentified", length = 10, nullable = false)
    private boolean isIdentified;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userDocsId")
    private UserDocs userDocs;

    public UserDocs getUserDocs() {
        return userDocs;
    }

    public void setUserDocs(UserDocs userDocs) {
        this.userDocs = userDocs;
    }

    /**
     * Конструктор для hibernate
     */
    public User() {

    }

    public User(String firstName, String secondName, String middleName,
                String position, String phone, String citizenshipName,
                String citizenshipCode, Long officeId, boolean isIdentified,UserDocs userDocs) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.officeId = officeId;
        this.isIdentified = isIdentified;
        this.userDocs=userDocs;

    }

    public User(Long id,String firstName, String secondName, String middleName,
                String position, String phone, String citizenshipName,
                String citizenshipCode, Long officeId, boolean isIdentified,UserDocs userDocs) {
        this.id=id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.officeId = officeId;
        this.isIdentified = isIdentified;
        this.userDocs=userDocs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public boolean isIdentified() {
        return isIdentified;
    }

    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", officeId=" + officeId +
                ", isIdentified=" + isIdentified +
                ", userDocs=" + userDocs +
                '}';
    }
}
