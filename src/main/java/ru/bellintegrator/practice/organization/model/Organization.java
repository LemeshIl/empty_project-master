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
    @Version
    private Integer version;

    /**
     * Иия
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Полное иия
     */
    @Column(name = "fullName", length = 50, nullable = false)
    private String fullName;

    /**
     * ИНН

     */
    @Column(name = "inn",length = 50, nullable = false)
    private String inn;


    /**
     * КПП
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "kpp", length = 50, nullable = false)
    private String kpp;

    /**
     * Адрес
     */
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    /**
     * телефон
     */
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    /**
     * Состояние
     */
    @Column(name = "is_active",  nullable = false)
    private boolean isActive;


    /**
     * Конструктор для hibernate
     */
    public Organization() {

    }


    public Organization(String name, String fullName, String inn, String kpp,
                        String address, String phone, boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn=" + inn +
                ", kpp=" + kpp +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", isActive=" + isActive +
                '}';
    }
}
