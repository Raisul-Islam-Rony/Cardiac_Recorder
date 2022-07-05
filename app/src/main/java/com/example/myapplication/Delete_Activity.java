package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Delete_Activity extends AppCompatActivity {
    private ArrayList<Record> arrayList;
    private RecyclerView recyclerView;

    private RecyclerAdapter.RecyclerViewClicklistener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        recyclerView = findViewById(R.id.Recycler_view);
        arrayList = new ArrayList<>();


        setUserInfo();
        setUserAdapter();


    }

    private void setUserInfo() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        arrayList = databaseHelper.fetchAlldata();

    }

    private void setUserAdapter() {
        setOnclickListener_Delete();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setOnclickListener_Delete() {

        listener = new RecyclerAdapter.RecyclerViewClicklistener() {
            @Override
            public void onClick(View v, int position) {
                String datee = arrayList.get(position).getDate();
                String timee = arrayList.get(position).getTime();

                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());

                databaseHelper.DeleteData(datee, timee);

                Intent intent = new Intent(getApplicationContext(),ViewList.class);
                startActivity(intent);
            }

        };
    }
}

//    public void setOnclickListener()
//    {
//        listener=new RecyclerAdapter.RecyclerViewClicklistener() {
//            @Override
//            public void onClick(View v, int position) {
//
//                Intent intent=new Intent(getApplicationContext(),Details_Activity.class);
//                intent.putExtra("Username",arrayList.get(position).getName());
//                intent.putExtra("Contact", arrayList.get(position).getContactNumber());
//                intent.putExtra("Time",arrayList.get(position).getTime());
//                intent.putExtra("Date", arrayList.get(position).getDate());
//                intent.putExtra("Heart_Rate",arrayList.get(position).getHeart_Rate());
//                intent.putExtra("Systolic",arrayList.get(position).getSystolic());
//                intent.putExtra("Diastolic",arrayList.get(position).getDiastolic());
//
//                startActivity(intent);
//
//
//
//            }
//        };
//    }
