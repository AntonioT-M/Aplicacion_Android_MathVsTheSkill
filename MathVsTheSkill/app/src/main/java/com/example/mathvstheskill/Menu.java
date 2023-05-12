package com.example.mathvstheskill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button btnJugar, BtnAdmin;
    MediaPlayer charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BtnAdmin = findViewById(R.id.btnAdmin);
        btnJugar = findViewById(R.id.btnJugar);
        charge = MediaPlayer.create(getApplicationContext(), R.raw.arma);

        BtnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charge.start();
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charge.start();
                Intent intent = new Intent(Menu.this, Game.class );
                startActivity(intent);

            }
        });

    }
}
