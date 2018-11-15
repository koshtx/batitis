package com.juancho.Model;

import java.util.UUID;

public class User {
    private Long id;
    private String name;
    private String password;
    private Boolean active;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.active = true;
    }

    public User(Long id, String name, String password, Integer active) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}
