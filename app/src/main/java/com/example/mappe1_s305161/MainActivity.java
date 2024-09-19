package com.example.mappe1_s305161;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button startSpillet = (Button) findViewById(R.id.startSpillet);
        startSpillet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startSpill = new Intent(MainActivity.this, Spill.class);
                startSpill.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //Istedet for å stacke alle aktiviteter vil tidligere aktivitet bli hentet frem. Dette sparer plass og lar brukeren gå tilbake uten å miste instillinger.
                startActivity(startSpill);
                Log.d("StartSpillet", "Start spillet knappen ble trykket.");

            }
        });
        Button preferanser = (Button) findViewById(R.id.preferanser);
        preferanser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent preferanser = new Intent(MainActivity.this, preferanser.class);
                preferanser.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //Istedet for å stacke alle aktiviteter vil tidligere aktivitet bli hentet frem. Dette sparer plass og lar brukeren gå tilbake uten å miste instillinger.
                startActivity(preferanser);
                Log.d("preferanser", "Start spillet knappen ble trykket.");

            }
        });
    }
}