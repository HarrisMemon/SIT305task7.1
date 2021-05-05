package com.example.a71task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a71task.data.DatabaseHelper;
import com.example.a71task.model.Note;

public class ViewNote extends AppCompatActivity {
    TextView noteText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
        noteText = findViewById(R.id.noteText);
        Button updatebutton = findViewById(R.id.updateButtton);
        Button deletebutton = findViewById(R.id.deleteButton);
        DatabaseHelper db = new DatabaseHelper(this);

        Intent intent = getIntent();
        String notetext = intent.getStringExtra("notetext");
        int noteid = intent.getIntExtra("noteID", 0);

        noteText.setText(notetext);


        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notet = noteText.getText().toString();
                db.updateText(new Note(notet), noteid);

                Intent intent = new Intent(ViewNote.this, AllNotes.class);
                startActivity(intent);

            }
        });

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.deleterow(noteid);
                Intent intent = new Intent(ViewNote.this, AllNotes.class);
                startActivity(intent);
            }
        });
    }


}