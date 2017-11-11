package com.tip.robinsonsappliances.ui.Login;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.tip.robinsonsappliances.app.Constants;




public class LoginViewState implements RestorableViewState<LoginView> {
    private String username;
    private String password;

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putString(Constants.USERNAME, username);
        out.putString(Constants.PASSWORD, password);
    }

    @Override
    public RestorableViewState<LoginView> restoreInstanceState(Bundle in) {
        username = in.getString(Constants.USERNAME, "");
        password = in.getString(Constants.PASSWORD, "");
        return this;
    }

    @Override
    public void apply(LoginView view, boolean retained) {
        view.setEditTextValue(username, password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
