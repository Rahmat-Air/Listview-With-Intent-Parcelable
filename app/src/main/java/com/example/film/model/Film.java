package com.example.film.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {

    public String nama_film;
    public String film_deskripsi;
    public String tahun;
    public String genre;
    public String skor_pengguna;
    public int foto;

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getSkor_pengguna() {
        return skor_pengguna;
    }

    public void setSkor_pengguna(String skor_pengguna) {
        this.skor_pengguna = skor_pengguna;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNama_film() {
        return nama_film;
    }

    public void setNama_film(String nama_film) {
        this.nama_film = nama_film;
    }

    public String getFilm_deskripsi() {
        return film_deskripsi;
    }

    public void setFilm_deskripsi(String film_deskripsi) {
        this.film_deskripsi = film_deskripsi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public Film() {

    }

    public Film(Parcel in) {
        nama_film = in.readString();
        film_deskripsi = in.readString();
        genre = in.readString();
        tahun = in.readString();
        skor_pengguna = in.readString();
        foto = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama_film);
        dest.writeString(film_deskripsi);
        dest.writeString(genre);
        dest.writeString(tahun);
        dest.writeString(skor_pengguna);
        dest.writeInt(foto);
    }


    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
