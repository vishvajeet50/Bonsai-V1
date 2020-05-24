package com.vishvajeet.bonsai.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vishvajeet.bonsai.Home.Home_screen;
import com.vishvajeet.bonsai.MainActivity;
import com.vishvajeet.bonsai.R;

public class Login_Screen extends AppCompatActivity {
    private Button loginBtn ;
    private EditText phoneNumber;
    private TextView errorPhone ;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        loginBtn = findViewById(R.id.login_btn);
        phoneNumber = findViewById(R.id.phoneNumber);
        errorPhone = findViewById(R.id.errorMessage);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_otp_Screen.class);
                String number = phoneNumber.getText().toString();
                 boolean validate = validNo(number);
                intent.putExtra("Mobile",number);
                if (validate)
                 startActivity(intent);
            }
        });

    }

    private boolean validNo(String no) {
        if (no.isEmpty() || no.length() < 10) {
            errorPhone.setVisibility(View.VISIBLE);
            errorPhone.setError("Enter a valid mobile");
            errorPhone.requestFocus();
            return false;
        }
        else return true;
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if(user != null){
            Intent homeIntent = new Intent(this, Home_screen.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            finish();
        }
    }
}