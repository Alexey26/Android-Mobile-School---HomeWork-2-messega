package com.example.alexey.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alexey.message.Percon.Person;
import com.example.alexey.message.Percon.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class listUsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);
        ArrayList<Person> personList = new ArrayList<>(Person.hm.values());
        int numberUsers = Person.hm.size();

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setAdapter(new UserAdapter(personList));
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
}
