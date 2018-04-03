package com.example.alexey.message;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alexey.message.Percon.Person;

import java.io.IOException;

public class sign_in extends AppCompatActivity  {

    Button butback, butPerson, butPhoto;
    EditText name, name_second, name_third, mail, phone, login, password;
    AutoCompleteTextView gender;
    static final int GALLERY_REQUEST = 1;
    Uri selectedImage = null;
    Bitmap bitmap = null;
    String[] genders = {"Мужской", "Женский"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        name = (EditText) findViewById(R.id.editText_name);
        name_second = (EditText) findViewById(R.id.editText_name2);
        name_third = (EditText) findViewById(R.id.editText_name3);
        mail = (EditText) findViewById(R.id.editText_email);
        phone = (EditText) findViewById(R.id.editText_phone);
        login = (EditText) findViewById(R.id.editText_login);
        password = (EditText) findViewById(R.id.editText_password);
        gender = (AutoCompleteTextView) findViewById(R.id.editText_Gender);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, genders);
        gender.setThreshold(0);
        gender.setAdapter(adapter);
        butback = (Button) findViewById(R.id.button_back);
        butback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        butPerson = (Button) findViewById(R.id.buttonPers);
        butPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().length() == 0 || name_second.getText().length() == 0
                        || login.getText().length() == 0 || password.getText().length() == 0)
                    Toast.makeText(sign_in.this, "Не заполнены поля *", Toast.LENGTH_LONG).show();
                else if(Person.hm.containsKey(login.getText().toString())){
                    Toast.makeText(sign_in.this,"Такой логин уже существует!", Toast.LENGTH_SHORT).show();
                    } else {
                    Person person = new Person(name.getText().toString(), name_second.getText().toString(),
                            name_third.getText().toString(), mail.getText().toString(),
                            phone.getText().toString(), gender.getText().toString(),
                            login.getText().toString(), password.getText().toString(), bitmap);
                    Person.hm.put(person.getLogin(), person);
                    bitmap = null;
                    Intent intent = new Intent(".Profile");
                    intent.putExtra("login", login.getText().toString());
                    startActivity(intent);
                }
            }
        });
        butPhoto = (Button) findViewById(R.id.buttonPhoto);
        butPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  //              Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (resultCode == RESULT_OK)
                    selectedImage = imageReturnedIntent.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }
    }
}
