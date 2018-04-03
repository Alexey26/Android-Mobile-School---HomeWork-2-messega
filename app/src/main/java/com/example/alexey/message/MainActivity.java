package com.example.alexey.message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexey.message.Percon.Person;

public class MainActivity extends AppCompatActivity {

    private Button butent, butreg;
    private EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.editText_logmain);
        password = (EditText) findViewById(R.id.edittext_passwordmain);

        butreg = (Button) findViewById(R.id.butreg);
        butreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".sign_in");
                startActivity(intent);
            }
        });
        butent = (Button) findViewById(R.id.butenter);
        butent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login.getText().length() == 0 || password.getText().length() == 0)
                    Toast.makeText(MainActivity.this, "Не заполнены поля", Toast.LENGTH_LONG).show();

                else if (Person.hm.containsKey(login.getText().toString()) &&
                        Person.hm.get(login.getText().toString()).getPassword().equals(password.getText().toString())) {
                    Intent intent = new Intent(".Profile");
                    intent.putExtra("login", login.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Не верный логин или пароль"  , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
