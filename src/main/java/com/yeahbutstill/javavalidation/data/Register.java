package com.yeahbutstill.javavalidation.data;

import com.yeahbutstill.javavalidation.constrain.CheckPassword;
import jakarta.validation.constraints.NotBlank;

@CheckPassword(message = "password must same with retypePassword")
public class Register {

    @NotBlank(message = "username must not blank")
    private String username;

    @NotBlank(message = "password must not blank")
    private String password;

    @NotBlank(message = "retypePassword must not blank")
    private String retypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }
}
