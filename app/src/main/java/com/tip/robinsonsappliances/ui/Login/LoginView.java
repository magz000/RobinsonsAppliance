package com.tip.robinsonsappliances.ui.Login;

import com.hannesdorfmann.mosby.mvp.MvpView;



public interface LoginView extends MvpView {

    void onLoginButtonClicked();

    void onRegisterButtonClicked();

    void showAlert(String message);

    void setEditTextValue(String username, String password);

    void startLoading();

    void stopLoading();

    void onLoginSuccess();
}
