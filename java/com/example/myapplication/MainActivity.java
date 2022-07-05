package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.*;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button view;
    Button add;
    Button update;
    Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        view=(Button) findViewById(R.id.view_button);
        add=(Button) findViewById(R.id.add_button);
        del=findViewById(R.id.Delete_ID);
        update=findViewById(R.id.update_id);


        //DatabaseHelper databaseHelper1=new DatabaseHelper(getApplicationContext());

        ArrayList<Record>arrayList=databaseHelper.fetchAlldata();

        TextView textView=findViewById(R.id.textView);
        textView.setText("Cardiac Recorder");

        ArrayList<Record> arrayList1 =new ArrayList<>();
        arrayList1= databaseHelper.fetchAlldata();
//        textView.setText("The total element on list is "+ arrayList1.size() );


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Update_Data.class);
                startActivity(intent);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SwitchToView(v);

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(56);

                SwitchToAdd(v);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Delete_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void SwitchToView(View view) {
        Intent intent=new Intent(MainActivity.this, ViewList.class);
        startActivity(intent);
    }

    private void SwitchToAdd(View view) {
        Intent intent=new Intent(MainActivity.this, AddRecord.class);
        startActivity(intent);
    }
}