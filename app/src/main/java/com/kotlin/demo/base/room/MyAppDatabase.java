package com.kotlin.demo.base.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import bergco.se.mvvm.model.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public static final String DB_NAME = "app_db";
    public static MyAppDatabase instance;

    public static synchronized MyAppDatabase getInstance (Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    MyAppDatabase.class,
                    DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract TasksDAO tasksDAO();
}
