package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;

public class UserView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String first_name;

    public String second_name;

    public String middle_name;

    public String position;

    public String phone;

    public String doc_name;

    public String doc_number;

    public String doc_date;

    public String citizen_ship_name;

    public String citizen_ship_code;

    public String office_id;

    public  boolean is_identified;

    @Override
    public String toString() {
        return "UserView{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", doc_name='" + doc_name + '\'' +
                ", doc_number='" + doc_number + '\'' +
                ", doc_date='" + doc_date + '\'' +
                ", citizen_ship_name='" + citizen_ship_name + '\'' +
                ", citizen_ship_code='" + citizen_ship_code + '\'' +
                ", office_id='" + office_id + '\'' +
                ", is_identified=" + is_identified +
                '}';
    }
}