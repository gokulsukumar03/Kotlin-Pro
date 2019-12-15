package com.kotlin.demo.unittesting.room;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Room;
import org.junit.runner.RunWith;

import java.util.List;

public class NoteRepository {

    private String DB_NAME = "db_task";

    private NoteDatabase noteDatabase;
    public NoteRepository(Context context) {
        noteDatabase = Room.databaseBuilder(context, NoteDatabase.class, DB_NAME).build();
    }

    public void insertTask(String title,
                           String description) {

        insertTask(title, description, false, null);
    }

    public void insertTask(String title,
                           String description,
                           boolean encrypt,
                           String password) {

        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);

        insertTask(note);
    }

    public void insertTask(final Note note) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.daoAccess().insertTask(note);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<Note> task = getTask(id);
        if(task != null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    noteDatabase.daoAccess().deleteTask(task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public void deleteTask(final Note note) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                noteDatabase.daoAccess().deleteTask(note);
                return null;
            }
        }.execute();
    }

    public LiveData<Note> getTask(int id) {
        return noteDatabase.daoAccess().getTask(id);
    }

    /*public LiveData<List<Note>> getTasks() {
        return noteDatabase.daoAccess().fetchAllTasks();
    }*/
}