package com.example.model;

public class ComplexObject {
    private String name;
    private int age;
    private String address;
    private boolean isActive;

    // Constructor
    public ComplexObject(String name, int age, String address, boolean isActive) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.isActive = isActive;
    }

    // Getters and Setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ComplexObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
