package com.metka.entity;

public class Goods {
    private Integer id;

    private String name;

    private Byte tagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getTagId() {
        return tagId;
    }

    public void setTagId(Byte tagId) {
        this.tagId = tagId;
    }
}