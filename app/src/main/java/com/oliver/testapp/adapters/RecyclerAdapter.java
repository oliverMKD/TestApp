package com.oliver.testapp.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oliver.testapp.R;
import com.oliver.testapp.klasi.Prasanja;

import java.lang.reflect.Type;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context mContext;
    ArrayList<Prasanja> odgovori;
    Prasanja mPrasanja;

    public RecyclerAdapter(Context context, ArrayList<Prasanja> mPrasanja) {
        this.mContext = context;
        this.odgovori = mPrasanja;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row,parent,false);
        RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        final Prasanja prasanja = odgovori.get(position);
        SharedPreferences sharedPrefs = mContext.getSharedPreferences("lol", MODE_PRIVATE);
        Boolean a = sharedPrefs.getBoolean("abc" + position, false);
        if (a){
            holder.toggleButton.setChecked(true);

        }else {
            holder.toggleButton.setChecked(false);

        }
        holder.tekst.setText(prasanja.getNaziv());
        holder.toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    SharedPreferences.Editor editor = mContext.getSharedPreferences("lol", MODE_PRIVATE).edit();
                    editor.putBoolean("abc" + position, true);
                    editor.apply();
                }
                else{
                    SharedPreferences.Editor editor = mContext.getSharedPreferences("lol", MODE_PRIVATE).edit();
                    editor.putBoolean("abc" + position, false);
                    editor.apply();

                }
            }
        });

    }


    @Override
    public int getItemCount() {
        if (odgovori==null){
            return 0;
        }
        return odgovori.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textPrv)
        TextView tekst;
        @BindView(R.id.toggle1)
        ToggleButton toggleButton;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
