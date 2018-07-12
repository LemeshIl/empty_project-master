package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.house.model.House;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Организация
 */
@Entity
@Table(name = "Organization")
public class Organization {

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
     * Иия
     */
    @Column(name = "first_name", length = 50, nullable = false)
    private String name;

    /**
     * Полное иия
     */
    @Column(name = "full_name", length = 50, nullable = false)
    private String full_name;

    /**
     * ИНН
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "inn", nullable = false)
    private int inn;


    /**
     * КПП
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "kpp", nullable = false)
    private int kpp;
    /**
     * Адрес
     */
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    /**
     * телефон
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "phone", nullable = false)
    private int phone;

    /**
     * Состояние
     */
    @Column(name = "is_active", length = 10, nullable = false)
    private boolean is_active;


    /**
     * Конструктор для hibernate
     */
    public Organization() {

    }

    public Organization(String name, String full_name, int inn, int kpp,
                        String address, int phone, boolean is_active) {
        this.name = name;
        this.full_name = full_name;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.is_active = is_active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public int getKpp() {
        return kpp;
    }

    public void setKpp(int kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", inn=" + inn +
                ", kpp=" + kpp +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", is_active=" + is_active +
                '}';
    }
}
