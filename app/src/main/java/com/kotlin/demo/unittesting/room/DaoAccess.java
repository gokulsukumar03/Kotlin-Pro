package com.kotlin.demo.unittesting.room;

import android.arch.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface DaoAccess {

    @Insert
    Long insertTask(Note note);

    @Query("SELECT * FROM Note")
    List<Note> fetchAllTasks();

    @Query("SELECT * FROM Note WHERE id =:taskId")
    LiveData<Note> getTask(int taskId);

    @Update
    void updateTask(Note note);

    @Delete
    void deleteTask(Note note);
}