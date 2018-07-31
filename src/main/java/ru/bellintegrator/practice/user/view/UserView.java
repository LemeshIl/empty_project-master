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

    public String citizenshipName;

    public String citizenshipCode;

    public String officeId;

    public boolean isIdentified;

    @ApiModelProperty(hidden = true)
    public String docId;

    public String docName;

    public String docCode;

    public String docNumber;

    public String docDate;


    @Override
    public String toString() {
        return "UserView{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", citizenshipName='" + citizenshipName + '\'' +
                ", citizenshipCode='" + citizenshipCode + '\'' +
                ", officeId='" + officeId + '\'' +
                ", isIdentified=" + isIdentified +
                ", docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", docCode='" + docCode + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", docDate='" + docDate + '\'' +
                '}';
    }
}