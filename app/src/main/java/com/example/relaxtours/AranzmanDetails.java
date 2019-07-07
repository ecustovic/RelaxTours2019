package com.example.relaxtours;

import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.relaxtours.DB.AranzmanSugarORM;
import com.example.relaxtours.Podaci.Aranzman;
import com.example.relaxtours.Podaci.AranzmaniDB;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AranzmanDetails extends AppCompatActivity {
    public TextView Naziv;
    public TextView  Termin;
    public TextView  Cijena;
    public TextView  Hotel;
    public TextView  Zvijezdice;
    public ImageView  Prijevoz;
    public TextView  Opis;
    public Button Rezervisi;
    public Button Otkazi;
    public ImageView Slika;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aranzman_details);
        final int id = getIntent().getIntExtra("id",0);

        final Aranzman a = AranzmaniDB.getByID(id);
        Naziv = findViewById(R.id.TV_Naziv);
        Termin = findViewById(R.id.TV_Termin);
        Cijena = findViewById(R.id.TV_Cijena);
        Hotel = findViewById(R.id.TV_Hotel);
        Zvijezdice = findViewById(R.id.TV_Zvijezdice);
        Prijevoz = findViewById(R.id.IV_Prevoz);
        Opis = findViewById(R.id.TV_Opis);
        Rezervisi = findViewById(R.id.BTN_Rezervisi);
        Otkazi = findViewById(R.id.BTN_Otkazi);
        Slika = findViewById(R.id.IV_Slika);
        Rezervisi.setVisibility(View.GONE);
        Otkazi.setVisibility(View.GONE);
        if (a != null){
         Naziv.setText(a.Naziv);
         Termin.setText(a.Termin);
         Cijena.setText(a.Cijena.toString());
         Hotel.setText(a.HotelNaziv);
         Zvijezdice.setText(a.HotelZ);
         Opis.setText(a.Opis);
         Naziv.setText(a.Naziv);
         if (a.NacinPrevoza.equals("Avion")) {
             Prijevoz.setImageDrawable(getDrawable(R.drawable.airplane));
         }
         if (a.NacinPrevoza.equals("Bus")) {
                Prijevoz.setImageDrawable(getDrawable(R.drawable.bus));
         }
            Glide.with(getApplicationContext())
                    .load(a.Slika)
                    .into(Slika);
             final List<AranzmanSugarORM> list =  AranzmanSugarORM.find(AranzmanSugarORM.class, "aranzmanid = ?", a.ID+"");


             if(list.size() == 0){
                 Rezervisi.setVisibility(View.VISIBLE);

                 Rezervisi.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         AranzmanSugarORM aranzmanSugarORM = new AranzmanSugarORM(a.ID, FirebaseAuth.getInstance().getUid());
                         aranzmanSugarORM.save();
                         Rezervisi.setVisibility(View.GONE);
                         Otkazi.setVisibility(View.VISIBLE);
                     }
                 });
             }else{
                 Otkazi.setVisibility(View.VISIBLE);

                 Otkazi.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                         list.get(0).delete();
                         Rezervisi.setVisibility(View.VISIBLE);
                         Otkazi.setVisibility(View.GONE);

                     }
                 });
             }


        }
    }
}
