package com.example.film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.film.Adapter.AdapterFilm;
import com.example.film.model.Film;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterFilm adapter;

    private SearchView cari;

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private String[] tahun13;
    private String[] genre;
    private String[] pengguna_skor;
    private ArrayList<Film> films;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list2);
        adapter = new AdapterFilm(this);
        listView.setAdapter(adapter);


        persiapan();
        tambahItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               Toast.makeText(MainActivity.this, films.get(i).getTahun(), Toast.LENGTH_SHORT).show();
                Intent pindah_data = new Intent(MainActivity.this, FilmDetailActivity.class);


                ArrayList<Film> movies = new ArrayList<Film>();

                Film film = new Film();
                film.setFoto(dataPhoto.getResourceId(i, -1));
                film.setNama_film(dataName[i]);
                film.setFilm_deskripsi(dataDescription[i]);
                film.setSkor_pengguna(pengguna_skor[i]);
                film.setGenre(genre[i]);
                film.setTahun(tahun13[i]);


                movies.add(film);

                pindah_data.putParcelableArrayListExtra(FilmDetailActivity.FILM_INI, movies);
                startActivity(pindah_data);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.pergi) {
            Intent ke = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(ke);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void persiapan() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        pengguna_skor = getResources().getStringArray(R.array.skor_pengguna);
        tahun13 = getResources().getStringArray(R.array.tahun_euy);
        genre = getResources().getStringArray(R.array.genre_euy);
    }

    private void tambahItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Film film = new Film();
            film.setFoto(dataPhoto.getResourceId(i, 0));
            film.setNama_film(dataName[i]);
            film.setFilm_deskripsi(dataDescription[i]);
            film.setTahun(tahun13[i]);
            film.setSkor_pengguna(pengguna_skor[i]);
            film.setGenre(genre[i]);
            films.add(film);
        }

        adapter.setFilm(films);
    }


}

