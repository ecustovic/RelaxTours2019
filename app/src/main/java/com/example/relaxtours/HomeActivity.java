package com.example.relaxtours;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.relaxtours.DB.AranzmanSugarORM;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private CardView cv_europa;
    private CardView cv_australia;
    private CardView cv_asia;
    private CardView cv_africa;
    private CardView cv_america;
    private ImageView   iv_draver;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cv_europa = findViewById(R.id.CV_Europa);
        cv_australia = findViewById(R.id.CV_Australia);
        cv_asia = findViewById(R.id.CV_Asia);
        cv_africa = findViewById(R.id.CV_Africa);
        cv_america = findViewById(R.id.CV_America);
        iv_draver = findViewById(R.id.IV_Menu);
        navigationView = findViewById(R.id.NV_Menu);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                DrawerLayout drawerLayout = findViewById(R.id.DL_DrawerHome);
                switch (menuItem.getItemId()) {
                    case R.id.MojeRezervacije:
                        Intent i = new Intent(getApplicationContext(),Rezervacije.class);
                        startActivity(i);
                        break;
                    case R.id.LogOut:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        break;


                }
                drawerLayout.closeDrawers();
                return true;
            }
        });


        iv_draver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout navDrawer = findViewById(R.id.DL_DrawerHome);
                // If navigation drawer is not open yet, open it else close it.
                if(!navDrawer.isDrawerOpen(GravityCompat.START)) navDrawer.openDrawer(Gravity.START);
                else navDrawer.closeDrawer(Gravity.END);
            }
        });


        cv_europa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AranzmaniActivity.class);
                intent.putExtra("naziv", "europa");
                startActivity(intent);
            }
        });

        cv_australia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AranzmaniActivity.class);
                intent.putExtra("naziv", "australia");
                startActivity(intent);
            }
        });


        cv_asia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AranzmaniActivity.class);
                intent.putExtra("naziv", "asia");
                startActivity(intent);
            }
        });


        cv_africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AranzmaniActivity.class);
                intent.putExtra("naziv", "africa");
                startActivity(intent);
            }
        });


        cv_america.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AranzmaniActivity.class);
                intent.putExtra("naziv", "america");
                startActivity(intent);
            }
        });


    }



}
