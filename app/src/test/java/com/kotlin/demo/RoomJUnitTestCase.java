package com.kotlin.demo;

import android.content.Context;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import com.kotlin.demo.unittesting.room.DaoAccess;
import com.kotlin.demo.unittesting.room.Note;
import com.kotlin.demo.unittesting.room.NoteDatabase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RoomJUnitTestCase {

    @Mock
    public NoteDatabase noteDatabase;

    @Mock
    public DaoAccess daoAccess;

    @Mock
    public Context context;

    @Before
    public void createDb() {
        MockitoAnnotations.initMocks(this);
        context = InstrumentationRegistry.getInstrumentation().getContext();
        noteDatabase = Room.inMemoryDatabaseBuilder(context, NoteDatabase.class).build();
        daoAccess = noteDatabase.daoAccess();
    }


    @Test
    public void test(){
        System.out.println("@@@@");
    }


    @Test
    public void insertData() {
        Note note = new Note();
        note.setTitle("Title");
        note.setDescription("Description");
        daoAccess.insertTask(note);

    }

    /*
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
