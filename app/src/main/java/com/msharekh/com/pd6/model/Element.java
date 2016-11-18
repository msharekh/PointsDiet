package com.msharekh.com.pd6.model;

/**
 * Created by MSH on 25/06/2016.
 */
public class Element {
    private int id;
    private String name;
    private String desc;
    private double points;
    private int categoryId;

    public Element(int id, String name, String desc, double points, int categoryId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
