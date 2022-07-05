package com.example.tutorial_mvvm.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import com.example.tutorial_mvvm.BR;
import com.example.tutorial_mvvm.main.MainActivity;
import com.example.tutorial_mvvm.model.User;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();
    public ObservableField<Boolean> isSucess = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogIn(View view){
        User user = new User(getEmail(),getPassword());
        isShowMessage.set(true);
        if(user.isValiEmail() && user.isValidPassword()){
            messageLogin.set("Login success");
            Context context = view.getContext();
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            isSucess.set(true);
        }else {
            messageLogin.set("Email or password invalid");
            isSucess.set(false);
        }
    }
}
