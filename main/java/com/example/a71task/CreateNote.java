package com.example.a71task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a71task.data.DatabaseHelper;
import com.example.a71task.model.Note;

public class CreateNote extends AppCompatActivity {
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);
        EditText noteText = findViewById(R.id.noteText);
        Button saveButton = findViewById(R.id.updateButtton);
        db = new DatabaseHelper(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notet = noteText.getText().toString();

                db.insertNote(new Note(notet));

                Intent intent = new Intent(CreateNote.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}