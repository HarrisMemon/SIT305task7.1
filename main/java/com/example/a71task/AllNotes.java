package com.example.a71task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.a71task.data.DatabaseHelper;
import com.example.a71task.model.Note;

import java.util.ArrayList;
import java.util.List;

public class AllNotes extends AppCompatActivity {
    ListView notesList;
    ArrayList<String> notesArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);
        notesList = findViewById(R.id.notesList);
        notesArrayList = new ArrayList<>();
        DatabaseHelper db = new DatabaseHelper(this);

        List<Note> notes = db.listAllNotes();

        for (Note note : notes){
            notesArrayList.add(note.getNote_text());

        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesArrayList);
        notesList.setAdapter(adapter);


        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = adapter.getItem(position);

                Intent intent = new Intent(AllNotes.this, ViewNote.class);
                intent.putExtra("notetext", item);
                intent.putExtra("noteID", notes.get(position).getNote_id());
                startActivity(intent);
            }
        });


    }

}