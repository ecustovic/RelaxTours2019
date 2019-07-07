package com.example.relaxtours;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.relaxtours.Podaci.Aranzman;

import java.util.List;

class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView  Naziv;
    public TextView  Termin;
    public TextView  Cijena;
    public ImageView  Slika;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        Naziv = itemView.findViewById(R.id.TV_Naziv);
        Termin = itemView.findViewById(R.id.TV_Termin);
        Cijena = itemView.findViewById(R.id.TV_Cijena);
        Slika = itemView.findViewById(R.id.IV_Slika);
    }
}
public class MojAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<Aranzman> data;
    private Activity ctx;

    public MojAdapter(List<Aranzman> data, Activity ctx) {
        this.data = data;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.stavka_aranzman,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final MyViewHolder _viewHolder = (MyViewHolder) viewHolder;
        _viewHolder.Cijena.setText(data.get(i).Cijena.toString());
        _viewHolder.Naziv.setText(data.get(i).Naziv.toString());
        _viewHolder.Termin.setText(data.get(i).Termin.toString());
        Glide.with(ctx)
                .load(data.get(i).Slika)
                .into(_viewHolder.Slika);

        _viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //otvoriti novi acc za selektianim aranzmanom
                int a = i;
                Intent i = new Intent(ctx,AranzmanDetails.class);
                i.putExtra("id", data.get(a).ID);
                ctx.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
            return data.size();
    }
}
