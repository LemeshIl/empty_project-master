package ru.bellintegrator.practice.organization.view;

import io.swagger.annotations.ApiModelProperty;

public class OrganizationShortView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String inn;

    public boolean isActive;


    @Override
    public String toString() {
        return "OrganizationShortView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", inn='" + inn + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}