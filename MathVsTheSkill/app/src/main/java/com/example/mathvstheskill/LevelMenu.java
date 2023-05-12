package com.example.mathvstheskill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelMenu extends AppCompatActivity {

    private Button level1,level2,level3,level4;
    MediaPlayer boom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_menu);

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);
        boom = MediaPlayer.create(getApplicationContext(), R.raw.seleccionar);

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                Intent inten = new Intent(LevelMenu.this, Game.class);
                startActivity(inten);
            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
            }
        });

        level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
            }
        });
    }
}
