package com.example.a71task.model;

public class Note {
    private int note_id;

    private String note_text;


    public Note(String note_text) {

        this.note_text = note_text;

    }

    public Note() {
    }



    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote_text() {
        return note_text;
    }

    public void setNote_text(String note_text) {
        this.note_text = note_text;
    }
}
