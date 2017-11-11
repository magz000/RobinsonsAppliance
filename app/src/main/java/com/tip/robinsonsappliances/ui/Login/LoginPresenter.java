package com.tip.robinsonsappliances.ui.Login;

import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.tip.robinsonsappliances.app.App;
import com.tip.robinsonsappliances.models.responses.LoginResponse;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter extends MvpNullObjectBasePresenter<LoginView> {
    private static final String TAG = LoginPresenter.class.getSimpleName();

    public void login(String username, final String password) {
        if (username.isEmpty()) {
            getView().showAlert("Enter Username");
        } else if (password.isEmpty()) {
            getView().showAlert("Enter Password");
        } else {

            getView().startLoading();

            App.getInstance().getApiInterface().login(username, password)
                    .enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call,
                                               final Response<LoginResponse> response) {
                            getView().stopLoading();
                            if (response.isSuccessful()) {
                                try {
                                    if (response.body().getMessage().equals("success")) {
                                        final Realm realm = Realm.getDefaultInstance();
                                        realm.executeTransactionAsync(
                                                new Realm.Transaction() {
                                                    @Override
                                                    public void execute(Realm realm) {
                                                        realm.copyToRealmOrUpdate(response.body().getUser());
                                                    }
                                                }, new Realm.Transaction.OnSuccess() {
                                                    @Override
                                                    public void onSuccess() {
                                                        realm.close();
                                                        getView().onLoginSuccess();
                                                    }
                                                }, new Realm.Transaction.OnError() {
                                                    @Override
                                                    public void onError(Throwable error) {
                                                        realm.close();
                                                        error.printStackTrace();
                                                        getView().showAlert("Failed");
                                                    }
                                                }

                                        );
                                    } else {
                                        getView().showAlert(response.body().getMessage());
                                    }
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                    getView().showAlert("No Record Found");
                                }

                            } else {
                                getView().showAlert(response.message() != null ? response.message()
                                        : "Unknown Error");
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e(TAG, "onFailure: Error calling login api", t);
                            getView().stopLoading();
                            getView().showAlert("Error Connecting to Server");
                        }
                    });
        }
    }
}
