package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;

public class UserView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public String docDate;

    public String citizenshipName;

    public String citizenshipCode;

    public String officeId;

    public  boolean isIdentified;

    @Override
    public String toString() {
        return "UserView{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", docName='" + docName + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", officeId='" + officeId + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}