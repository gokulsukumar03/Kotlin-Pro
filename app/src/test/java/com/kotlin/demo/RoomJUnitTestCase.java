package com.kotlin.demo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import androidx.room.Room;
import bergco.se.mvvm.model.Task;
import com.kotlin.demo.base.room.MyAppDatabase;
import com.kotlin.demo.base.room.TasksDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;


public class RoomJUnitTestCase {

    private MyAppDatabase db;
    private TasksDAO tasksDAO;
    private Task task;

    @Mock
    private Context context = Mockito.mock(Context.class);
    @Mock MyAppDatabase appDatabase;

    @Before
    public void createDb(){
        appDatabase = MyAppDatabase.getInstance(context);
        db = Room.inMemoryDatabaseBuilder(
                context,
                MyAppDatabase.class
        ).build();
        tasksDAO = db.tasksDAO();
    }

    @Test
    public void testTask(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        task = new Task();
        task.setTitle("Title");
        task.setDescription("Description");
        task.setGroupId("Group Id");
        tasksDAO.insertTask(task);

        LiveData<List<Task>> t = tasksDAO.observeTasksByGroupId("Group Id");
        t.observeForever(new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                assert tasks != null;
                Assert.assertEquals(1, tasks.size());

            }
        });
    }
}
