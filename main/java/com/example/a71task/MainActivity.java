package com.example.a71task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewNotes(View view) {
        Intent intent = new Intent(this, AllNotes.class);
        startActivity(intent);
    }
    public void createNote(View view) {
        Intent intent = new Intent(this, CreateNote.class);
        startActivity(intent);
    }
}