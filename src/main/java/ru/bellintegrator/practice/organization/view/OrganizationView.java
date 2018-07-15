package ru.bellintegrator.practice.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {

   // @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String inn;

    public String fullName;

    public String kpp;

    public String address;

    public String phone;

    public boolean isActive;


    @Override
    public String toString() {
        return "OrganizationView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", fullName='" + fullName + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}