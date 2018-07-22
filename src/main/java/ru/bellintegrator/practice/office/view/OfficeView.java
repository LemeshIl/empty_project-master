package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView  {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String address;

    public String phone;

    public String orgId;

    public boolean isActive;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", orgId='" + orgId + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}