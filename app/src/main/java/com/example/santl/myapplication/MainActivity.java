package com.example.santl.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }

    public void log_in(View view) {
        EditText roll_number = findViewById(R.id.roll_number);
        EditText password = findViewById(R.id.password);
        String roll_number1 = roll_number.getText().toString();
        String password1 = password.getText().toString();
        String type="log_in";
        Background bgLogin = new Background(this);
        bgLogin.execute(type,roll_number1,password1);
    }
}
