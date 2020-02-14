package com.example.songtracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button enter;
    Button view;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        enter = findViewById(R.id.enter);
        view = findViewById(R.id.view);

        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEnter();
            }
        });

        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openView();
            }
        });
    }

    private void openEnter() {
        Intent intent = new Intent(this, EnterActivity.class);
        startActivity(intent);
    }

    private void openView(){
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
