package com.example.film;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar kembali = getSupportActionBar();

        kembali.setDisplayShowHomeEnabled(true);
        kembali.setDisplayHomeAsUpEnabled(true);


    }
}
