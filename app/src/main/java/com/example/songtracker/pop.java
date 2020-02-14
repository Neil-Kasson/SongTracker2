package com.example.songtracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class pop extends AppCompatActivity {

    Button back2;
    TextView show;
    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        getSupportActionBar().hide();

        back2 = findViewById(R.id.back2);
        show = findViewById(R.id.show);

        Intent intent = getIntent();
        data = (String)intent.getSerializableExtra("data");

        show.setText(data);

        back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain();
            }
        });
    }

    private void openMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
