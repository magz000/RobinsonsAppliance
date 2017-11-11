package com.tip.robinsonsappliances.ui.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.tip.robinsonsappliances.R;
import com.tip.robinsonsappliances.databinding.ActivityLoginBinding;
import com.tip.robinsonsappliances.models.data.User;
import com.tip.robinsonsappliances.ui.Tabbed.activity.TabbedActivity;

import io.realm.Realm;


public class LoginActivity extends MvpActivity<LoginView, LoginPresenter>
        implements LoginView {

    private ActivityLoginBinding binding;
    private ProgressDialog progressDialog;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        setRetainInstance(true);
        realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).findFirst();
        if (user != null) onLoginSuccess();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setView(getMvpView());
    }

    @Override
    protected void onDestroy() {
        realm.close();
        super.onDestroy();
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @NonNull
    public ViewState<LoginView> createViewState() {
        setRetainInstance(true);
        return new LoginViewState();
    }

    @Override
    public void onLoginButtonClicked() {
        presenter.login(
                binding.username.getText().toString(),
                binding.password.getText().toString()
        );
    }

    @Override
    public void onRegisterButtonClicked() {

    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setEditTextValue(String username, String password) {
        binding.username.setText(username);
        binding.password.setText(password);
    }

    @Override
    public void startLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Logging in...");
        }
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        if (progressDialog != null) progressDialog.dismiss();
    }

    @Override
    public void onLoginSuccess() {
        //startActivity(new Intent(this, AppliancesListActivity.class));
        startActivity(new Intent(this, TabbedActivity.class));
        finish();
    }


}
