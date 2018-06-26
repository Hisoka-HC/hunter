package com.elabel.hospital.pojo.staff;

public class Position {
    public Integer id;
    public String name;
    public Integer superiorPositionId;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superiorPositionId=" + superiorPositionId +
                '}';
    }

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
        this.name = name;
    }

    public Integer getSuperiorPositionId() {
        return superiorPositionId;
    }

    public void setSuperiorPositionId(Integer superiorPositionId) {
        this.superiorPositionId = superiorPositionId;
    }

}
