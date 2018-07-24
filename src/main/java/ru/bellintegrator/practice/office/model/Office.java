package ru.bellintegrator.practice.office.model;

import javax.persistence.*;

/**
 * Oфис
 */
@Entity
@Table(name = "Office")
public class Office {

    @Id
    @SequenceGenerator(name = "SEQ_OFFICE", sequenceName = "SEQ_OFFICE", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_OFFICE", strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;

    /**
     * Имя
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Адрес
     */
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    /**
     * телефон
     */
    @Column(name = "phone", length = 100, nullable = false)
    private String phone;

    /**
     * id Организации
     */
    @Column(name = "orgId", nullable = false)
    private Long orgId;

    /**
     * Состояние
     */
    @Column(name = "isActive", length = 10, nullable = false)
    private boolean isActive;

    /**
     * Конструктор для hibernate
     */
    public Office() {

    }

    public Office(String name, String address, String phone, Long orgId, boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.orgId = orgId;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", orgId=" + orgId +
                ", isActive=" + isActive +
                '}';
    }
}
