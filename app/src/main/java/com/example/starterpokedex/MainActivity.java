package com.example.starterpokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int FIRE_TYPE = 0;
    public static final int WATER_TYPE = 1;
    public static final int GRASS_TYPE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeSpinners();


    }

    private void initializeSpinners() {
        Spinner fireSpinner = findViewById(R.id.fire);
        ArrayList<String> fireOptions = new ArrayList<>(Arrays.asList(pokeDB.fireStarter));
        fireOptions.add(0,"Fire");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, fireOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fireSpinner.setAdapter(adapter);
        fireSpinner.setOnItemSelectedListener( new PokeSelectedListener());

        Spinner grassSpinner = findViewById(R.id.grass);
        ArrayList<String> grassOptions = new ArrayList<>(Arrays.asList(pokeDB.grassStarter));
        grassOptions.add(0,"Grass");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, grassOptions);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        grassSpinner.setAdapter(adapter1);
        grassSpinner.setOnItemSelectedListener( new PokeSelectedListener());

        Spinner waterSpinner = findViewById(R.id.water);
        ArrayList<String> waterOptions = new ArrayList<>(Arrays.asList(pokeDB.waterStarter));
        waterOptions.add(0,"water");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, waterOptions);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterSpinner.setAdapter(adapter2);
        waterSpinner.setOnItemSelectedListener( new PokeSelectedListener());
    }

    private class PokeSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
        boolean selected = false;
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
            if(selected){
            if(adapterView.getId() == R.id.fire){
                Intent intent = new Intent(getApplicationContext(), PokeDescription.class);
                intent.putExtra("pokemon_position", pos - 1);
                intent.putExtra("pokemon_type", FIRE_TYPE);
                startActivity(intent);
            }
            if(adapterView.getId() == R.id.water){
                Intent intent = new Intent(getApplicationContext(), PokeDescription.class);
                intent.putExtra("pokemon_position", pos -1);
                intent.putExtra("pokemon_type", WATER_TYPE);
                startActivity(intent);
            }
            if(adapterView.getId() == R.id.grass){
                Intent intent = new Intent(getApplicationContext(), PokeDescription.class);
                intent.putExtra("pokemon_position", pos - 1);
                intent.putExtra("pokemon_type", GRASS_TYPE);
                startActivity(intent);
            }
                }
            else{
                selected = true;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}