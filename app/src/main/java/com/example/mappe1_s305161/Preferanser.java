package com.example.mappe1_s305161;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Preferanser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preferanser);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton norskBtn = findViewById(R.id.norskBtn);
        ImageButton tyskBtn = findViewById(R.id.tyskBtn);

        norskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("no");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

        tyskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocaleListCompat appLocale = LocaleListCompat.forLanguageTags("de");
                AppCompatDelegate.setApplicationLocales(appLocale);
            }
        });

        Button antallBtn5 = findViewById(R.id.Button5);
        antallBtn5.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
            SharedPreferences sharedPreferences = getSharedPreferences("Preferanser", MODE_PRIVATE);
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putInt("AntallRegnestykker", 5);
            editor.apply();
            }
        });
        Button antallBtn10 = findViewById(R.id.Button10);
        antallBtn10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences sharedPreferences = getSharedPreferences("Preferanser", MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putInt("AntallRegnestykker", 10);
                editor.apply();
            }
        });
        Button antallBtn15 = findViewById(R.id.Button15);
        antallBtn15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences sharedPreferences = getSharedPreferences("Preferanser", MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putInt("AntallRegnestykker", 15);
                editor.apply();
            }
        });
    }
}

