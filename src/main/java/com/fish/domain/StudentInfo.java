package com.fish.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="student_info")
public class StudentInfo {
    @Id
    private long id;
    private String name;
    private int age;
    @Column(name = "klass_info_id")
    private long klassInfoId;

    @Column(updatable = false, insertable = false)
    private String klassInfoName;

    public long getKlassInfoId() {
        return klassInfoId;
    }

    public void setKlassInfoId(long klassInfoId) {
        this.klassInfoId = klassInfoId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKlassInfoName() {
        return klassInfoName;
    }

    public void setKlassInfoName(String klassInfoName) {
        this.klassInfoName = klassInfoName;
    }
}
