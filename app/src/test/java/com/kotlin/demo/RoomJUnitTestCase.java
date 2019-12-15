package com.kotlin.demo;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import com.kotlin.demo.unittesting.room.DaoAccess;
import com.kotlin.demo.unittesting.room.NoteDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;


public class RoomJUnitTestCase {


    public NoteDatabase noteDatabase;


    public DaoAccess daoAccess;

    public Context context;

    @Before
    public void createDb() {
        MockitoAnnotations.initMocks(this);
        context =  ApplicationProvider.getApplicationContext();
      //  noteDatabase = Room.inMemoryDatabaseBuilder(context, NoteDatabase.class).build();
      //  daoAccess = noteDatabase.daoAccess();
    }


    @Test
    public void test(){
        System.out.println("@@@@");
    }


/*    @Test
    public void insertData() {
        Note note = new Note();
        note.setTitle("Title");
        note.setDescription("Description");
        daoAccess.insertTask(note);

    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        List<Note> notes = daoAccess.fetchAllTasks();
       for(int i=0;i<notes.size();i++){
           System.out.println(notes.get(i).getTitle());
       }
    }

    @After
    public void closeDb() throws IOException {
        noteDatabase.close();
    }*/

}
