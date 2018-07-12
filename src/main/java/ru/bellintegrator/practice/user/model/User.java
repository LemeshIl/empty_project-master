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
    @Column(name = "first_name", length = 50, nullable = false)
    private String first_name;

    /**
     * secondName
     */
    @Column(name = "second_name", length = 50, nullable = false)
    private String second_name;

    /**
     * middleName
     */
    @Column(name = "middle_name", length = 50, nullable = false)
    private String middle_name;

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
    @Column(name = "doc_name", length = 50, nullable = false)
    private String doc_name;

    /**
     * номер документа
     */
    @Column(name = "doc_number", nullable = false)
    private int doc_number;

    /**
     * дата рождения
     */
    @Column(name = "doc_date", length = 50, nullable = false)
    private String doc_date;

    /**
     * citizen_ship_name
     */
    @Column(name = "citizen_ship_name", length = 50, nullable = false)
    private String citizen_ship_name;

    /**
     * citizen_ship_code
     */
    @Column(name = "citizen_ship_code", length = 50, nullable = false)
    private String citizen_ship_code;

    /**
     * id офиса
     */
    @Column(name = "office_id", nullable = false)
    private Long office_id;

    /**
     * Состояние
     */
    @Column(name = "is_identified", length = 10, nullable = false)
    private boolean is_identified;


    /**
     * Конструктор для hibernate
     */
    public User() {

    }

    public User(boolean is_identified) {
        this.is_identified = is_identified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
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

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public int getDoc_number() {
        return doc_number;
    }

    public void setDoc_number(int doc_number) {
        this.doc_number = doc_number;
    }

    public String getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(String doc_date) {
        this.doc_date = doc_date;
    }

    public String getCitizen_ship_name() {
        return citizen_ship_name;
    }

    public void setCitizen_ship_name(String citizen_ship_name) {
        this.citizen_ship_name = citizen_ship_name;
    }

    public String getCitizen_ship_code() {
        return citizen_ship_code;
    }

    public void setCitizen_ship_code(String citizen_ship_code) {
        this.citizen_ship_code = citizen_ship_code;
    }

    public Long getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Long office_id) {
        this.office_id = office_id;
    }

    public User(String first_name, String second_name, String middle_name,
                String position, int phone, String doc_name, int doc_number,
                String doc_date, String citizen_ship_name,
                String citizen_ship_code, Long office_id, boolean is_identified) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.middle_name = middle_name;
        this.position = position;
        this.phone = phone;
        this.doc_name = doc_name;
        this.doc_number = doc_number;
        this.doc_date = doc_date;
        this.citizen_ship_name = citizen_ship_name;
        this.citizen_ship_code = citizen_ship_code;
        this.office_id = office_id;
        this.is_identified = is_identified;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", position='" + position + '\'' +
                ", phone=" + phone +
                ", doc_name='" + doc_name + '\'' +
                ", doc_number=" + doc_number +
                ", doc_date='" + doc_date + '\'' +
                ", citizen_ship_name='" + citizen_ship_name + '\'' +
                ", citizen_ship_code='" + citizen_ship_code + '\'' +
                ", office_id=" + office_id +
                ", is_identified=" + is_identified +
                '}';
    }
}
