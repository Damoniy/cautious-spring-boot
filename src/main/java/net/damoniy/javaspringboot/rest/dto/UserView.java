package net.damoniy.javaspringboot.rest.dto;

public class UserView {
    private final String name;
    private final String email;
    private final String phone;

    public UserView(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
