package com.example.songtracker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EnterActivity extends AppCompatActivity {

    EditText song;
    EditText artist;
    Button enter;
    Button back;
    static DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        getSupportActionBar().hide();

        myDB = new DatabaseHelper(this);

        song = findViewById(R.id.song);
        artist = findViewById(R.id.artist);
        enter = findViewById(R.id.enter);
        back = findViewById(R.id.back);

        enter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enterData();
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMain();
            }
        });
    }

    private void enterData() {
        String songTitle = song.getText().toString();
        String artistName = artist.getText().toString();

        SimpleDateFormat sDate =  new SimpleDateFormat("yyyy/MM/dd - h:mm aa");
        String date = sDate.format(new Date());

        // This is where the stuff goes that enters the data into the database
        if(songTitle.length()>0) {
            String s = "";
            if(artistName.length()>0){
                s = songTitle+"  by  "+artistName;
            } else {
                s = songTitle;
            }

            myDB.insertData(s, date);

            String f = (date+" - "+s);
            Intent intent = new Intent(this, pop.class);
            intent.putExtra ("data", f);
            startActivity(intent);
        }
    }

    private void openMain(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
