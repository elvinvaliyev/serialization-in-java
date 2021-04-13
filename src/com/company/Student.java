package com.company;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private transient long id;

    public Student(String name, String surname, int age, long id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
