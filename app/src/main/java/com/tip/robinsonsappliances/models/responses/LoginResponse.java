package com.tip.robinsonsappliances.models.responses;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tip.robinsonsappliances.models.data.User;


public class LoginResponse {

    private String username;
    private String password;

    @SerializedName("result")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private User user;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
