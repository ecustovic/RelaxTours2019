package com.example.relaxtours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.relaxtours.DB.AranzmanSugarORM;
import com.example.relaxtours.Podaci.Aranzman;
import com.example.relaxtours.Podaci.AranzmaniDB;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Rezervacije extends AppCompatActivity {

    private List<Aranzman> aranzmen;

    private RecyclerView recyclerView;
    private MojAdapter  mojAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranzmani);

        recyclerView = findViewById(R.id.RV_Podaci);

        List<AranzmanSugarORM> list = AranzmanSugarORM.find(AranzmanSugarORM.class, "userid = ?", FirebaseAuth.getInstance().getUid());



        aranzmen = new ArrayList<>();

        for (AranzmanSugarORM item : list) {
                aranzmen.add(AranzmaniDB.getByID(item.aranzmanid));
        }

        mojAdapter = new MojAdapter(aranzmen,Rezervacije.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mojAdapter);
        mojAdapter.notifyDataSetChanged();
    }
}
