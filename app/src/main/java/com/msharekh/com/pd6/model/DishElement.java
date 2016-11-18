package com.msharekh.com.pd6.model;

import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by MSH on 30/06/2016.
 */
public class DishElement extends RealmObject {





    private int elementId;
    private String name;
    private String desc;
    private Date dishDate;
    private double points;

    public DishElement() {
    }
    public DishElement(int elementId, String name, String desc, double points,Date dishDate) {
        this.elementId = elementId;
        this.name = name;
        this.dishDate=dishDate;
        this.desc = desc;
        this.points = points;
    }


    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDishDate() {
        return dishDate;
    }

    public void setDishDate(Date dishDate) {
        this.dishDate = dishDate;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
