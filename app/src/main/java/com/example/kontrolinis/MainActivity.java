package com.example.kontrolinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String[] reiksmes = {"Antano Gustaičio aviacijos institutas", "Aplinkos inžinerijos fakultetas",
            "Architektūros fakultetas", "Fundamentinių mokslų fakultetas", "Elektronikos fakultetas", "Mechanikos fakultetas",
            "Kūrybinių industrijų fakultetas", "Statybos fakultetas", "Transporto inžinerijos fakultetas", "Verslo vadybos fakultetas"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,reiksmes);

        AutoCompleteTextView fakai = findViewById(R.id.autoComplete);

        fakai.setThreshold(1);
        fakai.setAdapter(adapter);

        Button goToSecond = findViewById(R.id.goToSecond);

        goToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AutoCompleteTextView actv = findViewById(R.id.autoComplete);
                String reiksme = actv.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("reiksme", reiksme);
                startActivity(intent);

            }
        });
    }
}