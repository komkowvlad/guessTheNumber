package com.example.root.guessthenumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView questionText;
    int min, max;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        questionText = (TextView) findViewById(R.id.question);
        Intent i = getIntent();
        String minStr = i.getStringExtra("min");
        String maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);

        Log.d("my", "min = " + minStr + " max = "+maxStr);
        questionText.setText("Угадываем число от " + minStr + " до "+maxStr +
        "\nВаше число больше " + (max-min)/2+"?");

    }
    public int middle(int min, int max)
    {
        int midle= (int) ((min+max)/2);
     return midle;
    }
    public void onYesClick(View v)
    {
        min = middle(max,min);
        if ((middle(max,min)-min)==1)
        {
            questionText.setText("\nВаше число =" + (min+1));
        }
        else{questionText.setText("\nВаше число больше или равно " + middle(max, min) +"?");}
        }
    public void onNoClick(View v)
        {
            max = middle(max,min);
            if ((middle(max,min)-min)==1)
            {
                questionText.setText("\nВаше число =" + (min+1));
            }
            else{questionText.setText("\nВаше число больше или равно " + middle(max, min) +"?");}

        }
    public void onFinish(View v)
    {
        Intent i = new Intent(this, Again.class);
        startActivity(i);

    }





}
