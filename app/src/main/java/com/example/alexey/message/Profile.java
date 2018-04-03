package com.example.alexey.message;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexey.message.Percon.Person;
import com.example.alexey.message.R;

import java.io.IOException;

public class Profile extends AppCompatActivity {

    private Button butUsers;
    private TextView name, mail, phone, gender, login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = (TextView) findViewById(R.id.textView_name);
        mail = (TextView) findViewById(R.id.textView_mail1);
        phone = (TextView) findViewById(R.id.textView_phone1);
        gender = (TextView) findViewById(R.id.textView_gender1);
        login = (TextView) findViewById(R.id.textView_login1);
        password = (TextView) findViewById(R.id.textView_password1);



        Intent intent = getIntent();
        String loginStr = intent.getStringExtra("login");
        Person person = Person.hm.get(loginStr);
        name.setText(person.getfullName());
        mail.setText(person.getMail());
        phone.setText(person.getPhone());
        gender.setText(person.getGender());
        login.setText(person.getLogin());
        password.setText(person.getPassword());
        ImageView imageView = (ImageView) findViewById(R.id.profile_image);
        imageView.setImageBitmap(person.getSelectedImage());

        butUsers = (Button) findViewById(R.id.button_user);
        butUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".listUsers");
                startActivity(intent);
            }
        });
    }
}
