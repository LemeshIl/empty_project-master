package ru.bellintegrator.practice.user.model;

import ru.bellintegrator.practice.house.model.House;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    /**
     * Служебное поле hibernate
     */
//    @Version
//    private Integer version;


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
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "phone", nullable = false)
    private int phone;

    /**
     * имя документа
     */
    @Column(name = "docName", length = 50, nullable = false)
    private String docName;

    /**
     * номер документа
     */
    @Column(name = "docNumber", nullable = false)
    private int docNumber;

    /**
     * дата рождения
     */
    @Column(name = "docDate", length = 50, nullable = false)
    private String docDate;

    /**
     * citizenshipName
     */
    @Column(name = "citizenshipName", length = 50, nullable = false)
    private String citizenshipName;

    /**
     * citizenshipCode
     */
    @Column(name = "citizenshipCode", length = 50, nullable = false)
    private String citizenshipCode;

    /**
     * id офиса
     */
    @Column(name = "officeId", nullable = false)
    private Long officeId;

    /**
     * Состояние
     */
    @Column(name = "isIdentified", length = 10, nullable = false)
    private boolean isIdentified;


    /**
     * Конструктор для hibernate
     */
    public User() {

    }

    public User(String firstName, String secondName, String middleName, String position,
                int phone, String docName, int docNumber, String docDate, String citizenshipName,
                String citizenshipCode, Long officeId, boolean isIdentified) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.officeId = officeId;
        this.isIdentified = isIdentified;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(int docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
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
                ", phone=" + phone +
                ", docName='" + docName + '\'' +
                ", docNumber=" + docNumber +
                ", docDate='" + docDate + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", officeId=" + officeId +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
