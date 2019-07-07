package com.example.relaxtours;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.relaxtours.Podaci.Aranzman;
import com.example.relaxtours.Podaci.AranzmaniDB;
import com.google.android.gms.auth.api.signin.internal.Storage;

import java.util.ArrayList;
import java.util.List;

public class AranzmaniActivity extends AppCompatActivity {

    private List<Aranzman> aranzmen;

    private RecyclerView recyclerView;
    private MojAdapter  mojAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranzmani);

        Intent intent = getIntent();
        String s = intent.getStringExtra("naziv");
        recyclerView = findViewById(R.id.RV_Podaci);
        aranzmen = new ArrayList<>();

        for (Aranzman item : AranzmaniDB.getAranzmanListn()) {
            if (item.Kontinent.equals(s)){
                aranzmen.add(item);
            }
        }

        mojAdapter = new MojAdapter(aranzmen,AranzmaniActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(mojAdapter);
        mojAdapter.notifyDataSetChanged();
    }


}
