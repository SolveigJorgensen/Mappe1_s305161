package com.example.mappe1_s305161;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Spill extends AppCompatActivity {

    //Instans variabler

    int antallRegnestykker;
    String svaret ="";
    int teller = 0;
    int indexOfRegnestykket;

    // Oppretter Arrays fra xml
    String[] Regnestykker;
    int[] svar;
    ArrayList<Integer> shuffeldIndex;

    TextView mittSvar;
    TextView regnestykke;
    TextView tilbakemelding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spill);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("Preferanser", MODE_PRIVATE);
        antallRegnestykker = sharedPreferences.getInt("AntallRegnestykker", 5);

        Regnestykker = getResources().getStringArray(R.array.regnestykker);
        svar = getResources().getIntArray(R.array.svar);

        mittSvar = findViewById(R.id.dittSvar);
        regnestykke = findViewById(R.id.regnestykke);
        tilbakemelding = findViewById(R.id.tilbakemelding);

        publicLagArrayRegnestykker();
        hentRegnestykke();

        //INPUT
        View.OnClickListener lytter = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String tall = ((Button)v).getText().toString();
                svaret += tall;
                mittSvar.setText(svaret);
            }
        };
        for (int i = 0; i<= 9; i++) {
            String btnID = "btn" + i;
            int ID = getResources().getIdentifier(btnID, "id", getPackageName());
            Button button = findViewById(ID);
            button.setOnClickListener(lytter);
        }
        //SJEKK SVAR

        Button sjekkSvar = (Button) findViewById(R.id.sjekkSvarButton);
        sjekkSvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sjekkSvar();
                System.out.println(Regnestykker);
                System.out.println(svar);
                System.out.println(shuffeldIndex);
            }
        });

    }
    public void publicLagArrayRegnestykker() {
        shuffeldIndex = new ArrayList<>();

        for(int i=0; i < 15; i++){
            shuffeldIndex.add(i);
        }
        Collections.shuffle(shuffeldIndex, new Random());
    }


    public void hentRegnestykke(){

        if(teller < antallRegnestykker){
            indexOfRegnestykket = shuffeldIndex.get(teller);
            String regnestykkeVist = Regnestykker[indexOfRegnestykket];
            regnestykke.setText(regnestykkeVist);

        } else{
            regnestykke.setText(R.string.spillFerdig);}
    }

    public void sjekkSvar(){
        int riktigSvar = svar[indexOfRegnestykket];
        try {
            int svar = Integer.parseInt(svaret);
            if (svar == riktigSvar) {
                tilbakemelding.setText(R.string.tilbakemeldingR);
                teller++;
                hentRegnestykke();
                resetSvar();
            } else {
                tilbakemelding.setText(R.string.tilbakemeldingF);
                resetSvar();
            }
        } catch (NumberFormatException e){
            System.out.println(e);
        };
    }

    public void resetSvar(){
        svaret = "";
        mittSvar.setText(svaret);
    }
}