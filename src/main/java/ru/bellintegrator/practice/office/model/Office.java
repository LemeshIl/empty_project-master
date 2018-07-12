package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.house.model.House;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Oфис
 */
@Entity
@Table(name = "Office")
public class Office {

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
     * Имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address",length = 100, nullable = false)
    private String address;

    /**
     * телефон
     * т.к. поле примитивного типа, оно не может быть nullable
     */
    @Column(name = "phone", nullable = false)
    private int phone;

    /**
     * idOrganization
     */
    @Column(name = "org_id", nullable = false)
    private Long org_id;

    /**
     * Состояние
     */
    @Column(name = "is_active", length = 10, nullable = false)
    private boolean is_active;



    /**
     * Конструктор для hibernate
     */
    public Office() {

    }

    public Office(Integer version, String name, String address,
                  int phone, Long org_id, boolean is_active) {
        this.version = version;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.org_id = org_id;
        this.is_active = is_active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", orgId=" + org_id +
                ", isActive=" + is_active +
                '}';
    }
}
