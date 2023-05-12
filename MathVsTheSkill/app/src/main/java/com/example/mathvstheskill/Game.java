package com.example.mathvstheskill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

import android.os.Bundle;

public class Game extends AppCompatActivity {

    private View btnOpts, bProblems, fProblems, headGame1, headCounters;
    private int horas, minutos, segundos, milisegundos, n1, n2, n3, n4, resultado, resultadoA,
            resultadoB, n, points;
    private Double resultado1, n11, n22;
    private Thread countDown;
    private boolean isOn;
    private Handler h = new Handler(), h1 = new Handler();
    private String signo = "+*/-|", signo2 = "+*-/", signoM, signoF;
    private Random r = new Random();
    private TextView clockPlayer, puntos, problemaBasico, txtFra1A, txtFra1B, txtFra2A, txtFra2B,
            signoFra;
    private Button btnPrimero, btnSegundo, btnTercero, btnCuarto, btnResponder;
    private EditText respuestaBasica, respuestaA, respuestaB;

    private ImageView boomimg,kaboom1,kaboom2,kaboom3,kaboom4,kaboom5;

    private  final int DELAY = 396, Retraso = 700, Retraso1 = 100, Retraso2 = 65, Retraso3 = 75, Retraso4 = 85, Retraso5 = 300;


    MediaPlayer boom,game_over,correcto,incorrecto,win,tick,charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        boomimg = findViewById(R.id.snap);
        kaboom1 = findViewById(R.id.kaboom1);
        kaboom2 = findViewById(R.id.kaboom2);
        kaboom3 = findViewById(R.id.kaboom3);
        kaboom4 = findViewById(R.id.kaboom4);
        kaboom5 = findViewById(R.id.kaboom5);

        charge = MediaPlayer.create(getApplicationContext(), R.raw.arma);
        boom = MediaPlayer.create(getApplicationContext(), R.raw.seleccionar);
        correcto = MediaPlayer.create(getApplicationContext(), R.raw.respuesta_correcta);
        incorrecto = MediaPlayer.create(getApplicationContext(), R.raw.respuesta_incorrecta);
        game_over = MediaPlayer.create(getApplicationContext(), R.raw.game_over);
        win = MediaPlayer.create(getApplicationContext(), R.raw.win);
        tick = MediaPlayer.create(getApplicationContext(), R.raw.tictack);

        clockPlayer = findViewById(R.id.clockPlayer);
        puntos = findViewById(R.id.puntos);
        problemaBasico = findViewById(R.id.basicProblems);
        txtFra1A = findViewById(R.id.txtFra1A);
        txtFra1B = findViewById(R.id.txtFra1B);
        txtFra2A = findViewById(R.id.txtFra2A);
        txtFra2B = findViewById(R.id.txtFra2B);
        signoFra = findViewById(R.id.signoFra);
        btnPrimero = findViewById(R.id.btnPrimero);
        btnSegundo = findViewById(R.id.btnSegundo);
        btnTercero = findViewById(R.id.btnTercero);
        btnCuarto = findViewById(R.id.btnCuarto);
        btnResponder = findViewById(R.id.btnResponder);
        respuestaBasica = findViewById(R.id.respuesta);
        respuestaA = findViewById(R.id.respuestaA);
        respuestaB = findViewById(R.id.respuestaB);
        btnOpts = findViewById(R.id.btnsOpts);
        bProblems = findViewById(R.id.normalProblems);
        fProblems = findViewById(R.id.fractProblems);
        headGame1 = findViewById(R.id.headGame1);
        headCounters = findViewById(R.id.headCounters);
        points=0;
        verificar();
        startClock();
        boomimg.setVisibility(View.GONE);
        kaboom1.setVisibility(View.GONE);
        kaboom2.setVisibility(View.GONE);
        kaboom3.setVisibility(View.GONE);
        kaboom4.setVisibility(View.GONE);
        kaboom5.setVisibility(View.GONE);

        btnPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                minutos = 1;
                segundos = 0;
                milisegundos = 999;
                isOn = true;
                n = 1;
                problemas(n);
                ocultarBtns();
                mostrarHeadersG1();
                btnResponder.setVisibility(View.VISIBLE);
            }
        });

        btnSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                minutos = 1;
                segundos = 0;
                milisegundos = 999;
                isOn = true;
                n = 2;
                problemas(n);
                ocultarBtns();
                mostrarHeadersG1();
                btnResponder.setVisibility(View.VISIBLE);
            }
        });

        btnTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                minutos = 1;
                segundos = 0;
                milisegundos = 999;
                isOn = true;
                n = 3;
                problemas(n);
                ocultarBtns();
                mostrarHeadersG1();
                btnResponder.setVisibility(View.VISIBLE);
            }
        });

        btnCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                minutos = 1;
                segundos = 0;
                milisegundos = 999;
                isOn = true;
                n = 4;
                problemas(n);
                ocultarBtns();
                mostrarHeadersG1();
                btnResponder.setVisibility(View.VISIBLE);
            }
        });
    }


    private void ocultarHeadersG1(){
        headGame1.setVisibility(View.GONE);
        headCounters.setVisibility(View.GONE);
    }

    private void mostrarHeadersG1(){
        headGame1.setVisibility(View.VISIBLE);
        headCounters.setVisibility(View.VISIBLE);
    }

    private void ocultarBtns(){
        btnOpts.setVisibility(View.GONE);
    }

    private void mostrarBtns(){
        btnOpts.setVisibility(View.VISIBLE);
    }

    private void ocultarProblemsB(){
        bProblems.setVisibility(View.GONE);
    }

    private void ocultarProblemsF(){
        fProblems.setVisibility(View.GONE);
    }

    private void mostrarProblemsB(){
        bProblems.setVisibility(View.VISIBLE);
    }

    private void mostrarProblemsF(){
        fProblems.setVisibility(View.VISIBLE);
    }

    private void ocultarEdts()
    {
        respuestaBasica.setVisibility(View.GONE);
        respuestaA.setVisibility(View.GONE);
        respuestaB.setVisibility(View.GONE);
        boomimg.setVisibility(View.VISIBLE);
    }

    private void mostrarEdts()
    {
        boomimg.setVisibility(View.GONE);
        respuestaBasica.setVisibility(View.VISIBLE);
        respuestaA.setVisibility(View.VISIBLE);
        respuestaB.setVisibility(View.VISIBLE);
    }

    private void desaparecerEDT()
    {
        ocultarEdts();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarEdts();
            }
        }, DELAY);
    }

    private void kaboom1()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnResponder.setVisibility(View.GONE);
                kaboom1.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        kaboom1.setVisibility(View.GONE);
                        kaboom2.setVisibility(View.VISIBLE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                kaboom2.setVisibility(View.GONE);
                                kaboom3.setVisibility(View.VISIBLE);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        kaboom3.setVisibility(View.GONE);
                                        kaboom4.setVisibility(View.VISIBLE);

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                kaboom4.setVisibility(View.GONE);
                                                kaboom5.setVisibility(View.VISIBLE);

                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        kaboom5.setVisibility(View.GONE);
                                                        btnResponder.setVisibility(View.VISIBLE);
                                                    }
                                                }, Retraso5);
                                            }
                                        }, Retraso4);
                                    }
                                }, Retraso3);
                            }
                        }, Retraso2);
                    }
                }, Retraso1);
            }
        }, Retraso);
    }

    private void verificar(){
        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                charge.start();
                if(signoM.equals("+") || signoM.equals("-") || signoM.equals("x")){
                    if(respuestaBasica.length() >0){
                        if(Integer.parseInt(respuestaBasica.getText().toString()) == resultado){
                            points++;
                            segundos+=5;
                            correcto.start();
                            desaparecerEDT();
                            if(segundos > 59){
                                minutos+=1;
                                segundos=0+5;
                                if(minutos == 2){
                                    isOn = false;
                                    onWin();

                                }
                            }
                            puntos.setText(""+points);
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                        }else{
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                            kaboom1();
                        }
                    }else{
                        problemas(n);
                        incorrecto.start();
                        kaboom1();
                    }
                }else if(signoM.equals("÷")){
                    if(respuestaBasica.length() >0) {
                        if (Double.parseDouble(respuestaBasica.getText().toString()) == resultado1) {
                            points++;
                            segundos+=5;
                            correcto.start();
                            desaparecerEDT();
                            if(segundos > 59){
                                minutos+=1;
                                segundos=0+5;
                                if(minutos == 2){
                                    isOn = false;
                                    onWin();
                                }
                            }
                            puntos.setText("" + points);
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                        } else {
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                            kaboom1();
                        }
                    }else{
                        problemas(n);
                        incorrecto.start();
                        kaboom1();
                    }
                }else if(signoM.equals("|")){
                    if(respuestaA.length() >0 && respuestaB.length()>0) {
                        if (Integer.parseInt(respuestaA.getText().toString()) == resultadoA &&
                                Integer.parseInt(respuestaB.getText().toString()) == resultadoB) {
                            points++;
                            segundos+=5;
                            correcto.start();
                            desaparecerEDT();
                            if(segundos > 59){
                                minutos+=1;
                                segundos=0+5;
                                if(minutos == 2){
                                    isOn = false;
                                    onWin();
                                }
                            }
                            puntos.setText("" + points);
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                        } else {
                            respuestaBasica.setText("");
                            problemas(n);
                            incorrecto.start();
                            kaboom1();
                        }
                    }else{
                        problemas(n);
                        incorrecto.start();
                        kaboom1();
                    }
                }
            }
        });
    }

    private void problemas(int n){
        signoM = String.valueOf(signo.charAt(r.nextInt(signo.length())));
        if(signoM.equals("+")){
            if(n == 1){
                n1 = (int) (Math.random() * 20) + 1;
                n2 = (int) (Math.random() * 20) + 1;
                resultado = n1 + n2;
                mostrarProblemsB();
                ocultarProblemsF();
                problemaBasico.setText(n1+signoM+n2+"=");
            }else if(n == 2){
                n1 = (int) (Math.random() * 99) + 1;
                n2 = (int) (Math.random() * 99) + 1;
                resultado = n1 + n2;
                mostrarProblemsB();
                ocultarProblemsF();
                problemaBasico.setText(n1+signoM+n2+"=");
            }else if(n == 3){
                n1 = (int) (Math.random() * 500) + 1;
                n2 = (int) (Math.random() * 500) + 1;
                resultado = n1 + n2;
                mostrarProblemsB();
                ocultarProblemsF();
                problemaBasico.setText(n1+signoM+n2+"=");
            }else if(n == 4){
                n1 = (int) (Math.random() * 1000) + 1;
                n2 = (int) (Math.random() * 1000) + 1;
                resultado = n1 + n2;
                mostrarProblemsB();
                ocultarProblemsF();
                problemaBasico.setText(n1+signoM+n2+"=");
            }
        }else if(signoM.equals("-")){
            if(n == 1){
                n1 = (int) (Math.random() * 20) + 1;
                n2 = (int) (Math.random() * 20) + 1;
                resultado = n1 - n2;
                mostrarProblemsB();
                ocultarProblemsF();
                if(resultado < 0){
                    resultado = n2 - n1;
                    problemaBasico.setText(n2+signoM+n1+"=");
                }else{
                    problemaBasico.setText(n1+signoM+n2+"=");
                }
            }else if(n == 2){
                n1 = (int) (Math.random() * 99) + 1;
                n2 = (int) (Math.random() * 99) + 1;
                resultado = n1 - n2;
                mostrarProblemsB();
                ocultarProblemsF();
                if(resultado < 0){
                    resultado = n2 - n1;
                    problemaBasico.setText(n2+signoM+n1+"=");
                }else{
                    problemaBasico.setText(n1+signoM+n2+"=");
                }
            }else if(n == 3){
                n1 = (int) (Math.random() * 500) + 1;
                n2 = (int) (Math.random() * 500) + 1;
                resultado = n1 - n2;
                mostrarProblemsB();
                ocultarProblemsF();
                if(resultado < 0){
                    resultado = n2 - n1;
                    problemaBasico.setText(n2+signoM+n1+"=");
                }else{
                    problemaBasico.setText(n1+signoM+n2+"=");
                }
            }else if(n == 4){
                n1 = (int) (Math.random() * 1000) + 1;
                n2 = (int) (Math.random() * 1000) + 1;
                resultado = n1 - n2;
                mostrarProblemsB();
                ocultarProblemsF();
                if(resultado < 0){
                    resultado = n2 - n1;
                    problemaBasico.setText(n2+signoM+n1+"=");
                }else{
                    problemaBasico.setText(n1+signoM+n2+"=");
                }
            }
        }else if(signoM.equals("*")){
            if(n == 2){
                n1 = (int) (Math.random() * 20) + 1;
                n2 = (int) (Math.random() * 20) + 1;
                resultado = n1 * n2;
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "x";
                problemaBasico.setText(n1+signoM+n2+"=");
            }else if(n == 3){
                n1 = (int) (Math.random() * 99) + 1;
                n2 = (int) (Math.random() * 99) + 1;
                resultado = n1 * n2;
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "x";
                problemaBasico.setText(n1+signoM+n2+"=");
            }else if(n == 4){
                n1 = (int) (Math.random() * 500) + 1;
                n2 = (int) (Math.random() * 500) + 1;
                resultado = n1 * n2;
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "x";
                problemaBasico.setText(n1+signoM+n2+"=");
            }else{
                problemas(n);
            }
        }else if(signoM.equals("/")){
            DecimalFormat format1 = new DecimalFormat("#.###");
            DecimalFormat format = new DecimalFormat("#");
            if(n == 2){
                n11 = Double.parseDouble(format.format((Math.random() * 50) + 1));
                n22 = Double.parseDouble(format.format((Math.random() * 50) + 1));
                resultado1 = Double.parseDouble(format1.format((n11/n22)));
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "÷";
                if(resultado1 >= 0.000 || resultado1 > 0.00){
                    resultado1 = Double.parseDouble((resultado1.toString()).substring(0, resultado1.toString().length()-1));
                }
            }else if(n == 3){
                n11 = Double.parseDouble(format.format((Math.random() * 99) + 1));
                n22 = Double.parseDouble(format.format((Math.random() * 99) + 1));
                resultado1 = Double.parseDouble(format1.format((n11/n22)));
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "÷";
                if(resultado1 >= 0.000 || resultado1 > 0.00){
                    resultado1 = Double.parseDouble((resultado1.toString()).substring(0, resultado1.toString().length()-1));
                }
            }else if(n == 4){
                n11 = Double.parseDouble(format.format((Math.random() * 500) + 1));
                n22 = Double.parseDouble(format.format((Math.random() * 500) + 1));
                resultado1 = Double.parseDouble(format1.format((n11/n22)));
                mostrarProblemsB();
                ocultarProblemsF();
                signoM = "÷";
                if(resultado1 >= 0.000 || resultado1 > 0.00){
                    resultado1 = Double.parseDouble((resultado1.toString()).substring(0, resultado1.toString().length()-1));
                }
                problemaBasico.setText(n11.intValue()+signoM+n22.intValue()+"=");
            }else{
                problemas(n);
            }
        }else if(signoM.equals("|")){
            if(n == 4){
                n1 = (int) (Math.random() * 5) + 1;
                n2 = (int) (Math.random() * 5) + 1;
                n3 = (int) (Math.random() * 5) + 1;
                signoF = String.valueOf(signo2.charAt(r.nextInt(signo2.length())));
                ocultarProblemsB();
                mostrarProblemsF();
                if(n1 == n2){
                    problemas(n);
                }
                if(signoF.equals("+")){
                    resultadoA = n1 + n2;
                    resultadoB = n3;
                    signoFra.setText(""+signoF);
                    txtFra1A.setText(""+n1);
                    txtFra2A.setText(""+n2);
                    txtFra1B.setText(""+n3);
                    txtFra2B.setText(""+n3);
                }else if(signoF.equals("-")){
                    resultadoA = n1 - n2;
                    resultadoB = n3;
                    if(resultadoA <=0){
                        resultadoA = n2 - n1;
                        signoFra.setText(""+signoF);
                        txtFra1A.setText(""+n2);
                        txtFra2A.setText(""+n1);
                        txtFra1B.setText(""+n3);
                        txtFra2B.setText(""+n3);
                    }else{
                        signoFra.setText(""+signoF);
                        txtFra1A.setText(""+n1);
                        txtFra2A.setText(""+n2);
                        txtFra1B.setText(""+n3);
                        txtFra2B.setText(""+n3);
                    }
                }else if(signoF.equals("*")){
                    resultadoA = n1 * n2;
                    resultadoB = n3 * n3;
                    signoF = "x";
                    signoFra.setText(""+signoF);
                    txtFra1A.setText(""+n1);
                    txtFra2A.setText(""+n2);
                    txtFra1B.setText(""+n3);
                    txtFra2B.setText(""+n3);
                }else if(signoF.equals("/")){
                    resultadoA = n1 * n3;
                    resultadoB = n2 * n3;
                    signoF = "÷";
                    signoFra.setText(""+signoF);
                    txtFra1A.setText(""+n1);
                    txtFra2A.setText(""+n2);
                    txtFra1B.setText(""+n3);
                    txtFra2B.setText(""+n3);
                }
            }else{
                problemas(n);
            }
        }
    }

    private void startClock(){
        horas = 0;
        minutos = 1;
        segundos = 0;
        milisegundos = 999;
        countDown = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if(isOn){
                        try{
                            Thread.sleep(1);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        milisegundos--;
                        if(milisegundos == 0 && segundos == 0){
                            isOn = false;
                            h1.post(new Runnable() {
                                @Override
                                public void run() {
                                    onFinish();
                                }
                            });
                        }
                        if(milisegundos == 0 && segundos != 0){
                            segundos--;
                            milisegundos = 999;
                        }
                        if(segundos == 0 && minutos != 0){
                            minutos--;
                            segundos = 59;
                        }
                        if(minutos == 0 && horas != 0){
                            horas--;
                            minutos = 59;
                        }
                        h.post(new Runnable() {
                            @Override
                            public void run() {
                                String s="", m="",h="";

                                if(segundos <10){
                                    s="0"+segundos;
                                    tick.start();
                                    if(segundos <2){
                                        tick.stop();
                                    }
                                }else{
                                    s=""+segundos;
                                }

                                if(minutos <10){
                                    m="0"+minutos;
                                }else{
                                    m=""+minutos;
                                }

                                if(horas <10){
                                    h="0"+horas;
                                }else {
                                    h=""+horas;
                                }
                                clockPlayer.setText(m+":"+s);
                            }
                        });
                    }
                }
            }
        });
        countDown.start();
    }

    private void onFinish(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
        game_over.start();
        builder.setView(R.layout.dialog_game_over);
        builder.setTitle("Perdiste 😢");
        builder.setMessage("Player A obtuviste: "+points+" puntos\nGAME OVER!! 🥺")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mostrarBtns();
                        ocultarHeadersG1();
                        ocultarProblemsB();
                        ocultarProblemsF();
                        btnResponder.setVisibility(View.GONE);
                        puntos.setText(""+0);
                        points = 0;
                        Toast.makeText(Game.this, "Puntos guardados", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void onWin(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Game.this);
        win.start();
        builder.setView(R.layout.dialog_game_win);
        builder.setTitle("Ganaste 😳");
        builder.setMessage("Player A obtuviste: "+points+" puntos\nFelicidades!! 😁👍")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ocultarHeadersG1();
                        ocultarProblemsB();
                        ocultarProblemsF();
                        mostrarBtns();
                        btnResponder.setVisibility(View.GONE);
                        puntos.setText(""+0);
                        points = 0;
                        Toast.makeText(Game.this, "Puntos guardados", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
