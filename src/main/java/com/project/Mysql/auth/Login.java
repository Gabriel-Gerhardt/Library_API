package com.project.Mysql.auth;

public class Login {

    private String email;
    private String password;

    // Construtor vazio necessário para o Spring
    public Login() {}

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
