package com.example.starterpokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PokeDescription extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedescription);
        Intent intent = getIntent();
        int type = intent.getIntExtra("pokemon_type",0);
        int pokemonPosition = intent.getIntExtra("pokemon_position",0);

        String name;
        String description;
        int id;
        switch(type){
            case MainActivity.FIRE_TYPE:
                name = pokeDB.fireStarter[pokemonPosition];
                description = pokeDB.fireDescription[pokemonPosition];
                id = pokeDB.fireID[pokemonPosition];
                TextView nameFire = findViewById(R.id.name);
                nameFire.setText(name);
                ImageView imageFire = findViewById(R.id.picture);
                imageFire.setImageResource(id);
                TextView descriptionFire = findViewById(R.id.description);
                descriptionFire.setText(description);
            break;
            case MainActivity.WATER_TYPE:
                name = pokeDB.waterStarter[pokemonPosition];
                description = pokeDB.waterDescription[pokemonPosition];
                id = pokeDB.waterID[pokemonPosition];
                TextView nameWater = findViewById(R.id.name);
                nameWater.setText(name);
                ImageView imageWater = findViewById(R.id.picture);
                imageWater.setImageResource(id);
                TextView descriptionWater = findViewById(R.id.description);
                descriptionWater.setText(description);
                break;
            case MainActivity.GRASS_TYPE:
                name = pokeDB.grassStarter[pokemonPosition];
                description = pokeDB.grassDescription[pokemonPosition];
                id = pokeDB.grassID[pokemonPosition];
                TextView nameGrass = findViewById(R.id.name);
                nameGrass.setText(name);
                ImageView imageGrass = findViewById(R.id.picture);
                imageGrass.setImageResource(id);
                TextView descriptionGrass = findViewById(R.id.description);
                descriptionGrass.setText(description);
                break;

        }

    }
    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
