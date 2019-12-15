package com.kotlin.demo.unittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.room.RoomDatabase;
import bergco.se.mvvm.model.Task;
import com.kotlin.demo.R;
import com.kotlin.demo.base.room.MyAppDatabase;

public class LoginJUnitActivity extends AppCompatActivity {

    private EditText mobileEt, emailEt, passwordEt;
    private Button submitBtn;
    LoginCredentials login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_junit);
        init();
    }

    private void init(){
        mobileEt  =  (EditText) findViewById(R.id.mobileEt);
        emailEt   =  (EditText) findViewById(R.id.emailEt);
        passwordEt=  (EditText) findViewById(R.id.passwordEt);
        submitBtn =  (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = new LoginCredentials();
                login.setEmail(emailEt.getText().toString());
                login.setMobile(mobileEt.getText().toString());
                login.setPassword(passwordEt.getText().toString());
                verify();
                verifyCredentials(login);
            }
        });

        final MyAppDatabase appDatabase = MyAppDatabase.getInstance(this);
        final Task task = new Task();
        task.setTitle(" ddd");
        task.setGroupId("ddd");
        task.setDescription("ddffdfd");
        new Thread(new Runnable() {
            @Override
            public void run() {
                appDatabase.tasksDAO().insertTask(task);
            }
        });

    }

    public LoginCredentials verify(){
        return login;
    }

    private void verifyCredentials(LoginCredentials loginCredentials){


    }
}
