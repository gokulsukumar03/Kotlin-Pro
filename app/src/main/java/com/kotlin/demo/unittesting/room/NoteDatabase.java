package com.kotlin.demo.unittesting.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}