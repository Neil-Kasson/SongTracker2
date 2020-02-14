package com.example.songtracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    Button back3;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    static DatabaseHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        getSupportActionBar().hide();

        myDB = new DatabaseHelper(this);
        ArrayList<Item> itemList = myDB.getData();

        back3 = findViewById(R.id.back3);
        recycler = findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ItemAdapter(itemList);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);



        back3.setOnClickListener(new View.OnClickListener(){
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
