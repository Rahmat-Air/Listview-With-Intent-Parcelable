package com.example.film.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.film.R;
import com.example.film.model.Film;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilm extends BaseAdapter {

    private final Context context;
    private ArrayList<Film> film1 = new ArrayList<>();
    private List<Film> filmList;

    public void setFilm(ArrayList<Film> film) {
        this.film1 = film;
        this.filmList = film1;
    }

    public AdapterFilm(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return film1.size();
    }

    @Override
    public Object getItem(int i) {
        return filmList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.lay, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return itemView;
    }


    private class ViewHolder {
        private TextView nama;
        private TextView desk;
        private ImageView poto;
        private TextView skor;

        ViewHolder(View view) {
            nama = view.findViewById(R.id.nama_film);
            desk = view.findViewById(R.id.desk);
            poto = view.findViewById(R.id.imageView);
            skor = view.findViewById(R.id.skor9);
        }

        void bind(Film film) {
            nama.setText(film.getNama_film());
            desk.setText(film.getFilm_deskripsi());
            poto.setImageResource(film.getFoto());
        }
    }


}









