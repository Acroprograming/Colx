package com.example.santl.myapplication;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        final TextInputLayout fnameWrapper = (TextInputLayout) findViewById(R.id.fnameWraper);
        fnameWrapper.setHint("First Name");
        final TextInputLayout lnameWraper = (TextInputLayout) findViewById(R.id.lnameWraper);
        lnameWraper.setHint("Last Name");
        final TextInputLayout roll_numberWraper = (TextInputLayout) findViewById(R.id.roll_numberWraper);
        roll_numberWraper.setHint("Roll Number");
        final TextInputLayout yearWraper = (TextInputLayout) findViewById(R.id.yearWrapper);
        yearWraper.setHint("Year");
        final TextInputLayout classWrapper = (TextInputLayout) findViewById(R.id.classWrapper);
        classWrapper.setHint("Class");
        final TextInputLayout sectionWraper = (TextInputLayout) findViewById(R.id.sectionWrapper);
        sectionWraper.setHint("Section");
        final TextInputLayout mobile_numberWrapper = (TextInputLayout) findViewById(R.id.mobile_numberWrapper);
        mobile_numberWrapper.setHint("Mobile Number");
        final TextInputLayout emailwraper = (TextInputLayout) findViewById(R.id.emailWraper);
        emailwraper.setHint("Email");
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWraper1);
        passwordWrapper.setHint("Password");

    }

    public void signup(View view) {
        EditText fname = findViewById(R.id.fname);
        EditText lname = findViewById(R.id.lname);
        EditText roll_number  = findViewById(R.id.roll_number1);
        EditText year = findViewById(R.id.year);
        EditText Class = findViewById(R.id.Class);
        EditText section = findViewById(R.id.section);
        EditText mobile_number = findViewById(R.id.mobile_number);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password_signup);
        String fname1 = fname.getText().toString();
        String lname1=lname.getText().toString();
        String year1=year.getText().toString();
        String roll_number1 = roll_number.getText().toString();
        String Class1=Class.getText().toString();
        String email1 = email.getText().toString();
        String section1=section.getText().toString();
        String password1 = password.getText().toString();
        String mobile_number1=mobile_number.getText().toString();
        String type ="signup";
        Background backgroundSignup = new Background(this);
        backgroundSignup.execute(type,fname1,lname1,roll_number1,year1,Class1,section1,mobile_number1,email1,password1);

    }
}
