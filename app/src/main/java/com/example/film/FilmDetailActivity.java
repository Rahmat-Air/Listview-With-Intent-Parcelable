package com.example.film;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.film.model.Film;

import java.util.ArrayList;

public class FilmDetailActivity extends AppCompatActivity {


    String nama1, desk1, genre1, tahun1, skor1;
    int poster_gambar;
    TextView nama, desk, genre, tahun, skor;
    ImageView foto;


    public static final String FILM_INI = "test_extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        ArrayList<Film> films = this.getIntent().getParcelableArrayListExtra(FILM_INI);

        nama = findViewById(R.id.nama_film);
        foto = findViewById(R.id.poster_ini);
        desk = findViewById(R.id.deskripsi);
        genre = findViewById(R.id.genre);
        tahun = findViewById(R.id.tahun9);
        skor = findViewById(R.id.skor9);

        ActionBar kembali = getSupportActionBar();
        kembali.setDisplayShowHomeEnabled(true);
        kembali.setDisplayHomeAsUpEnabled(true);


        poster_gambar = films.get(0).getFoto();
        foto.setImageResource(poster_gambar);

        nama1 = films.get(0).getNama_film();
        nama.setText(nama1);

        desk1 = films.get(0).getFilm_deskripsi();
        desk.setText(desk1);

        genre1 = films.get(0).getGenre();
        genre.setText(genre1);

        tahun1 = films.get(0).getTahun();
        tahun.setText(tahun1);

        skor1 = films.get(0).getSkor_pengguna();
        skor.setText(skor1);


    }
}
