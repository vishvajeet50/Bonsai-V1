package com.vishvajeet.bonsai.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.vishvajeet.bonsai.Login.Login_Screen;
import com.vishvajeet.bonsai.R;

public class Home_screen extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        bottomNavigationView = findViewById(R.id.bottom_nav_home);
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if(user == null){
            Intent loginIntent = new Intent(this, Login_Screen.class);
            loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();
        }
    }
}
