package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    private ArrayList<Record>arrayList;
    private RecyclerViewClicklistener listener;

    public RecyclerAdapter(ArrayList<Record> arrayList, RecyclerViewClicklistener listener) {
        this.arrayList = arrayList;
        this.listener=listener;

    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String pressure_systolic= arrayList.get(position).getSystolic();
        String pressure_diastolic= arrayList.get(position).getDiastolic();

        String pressure="Pressure is: "+ pressure_diastolic + "/" +pressure_systolic + "mm Hg";
        String date=arrayList.get(position).getDate();
        date = "on : " + date;
        holder.pressure.setText(pressure);
        holder.date.setText(date);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView pressure;
        private TextView date;

        public MyViewHolder(final View itemView) {
            super(itemView);


            pressure=itemView.findViewById(R.id.pressure_id);
            date=itemView.findViewById(R.id.date_id);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            listener.onClick(v,getAdapterPosition());

        }
    }

    public interface RecyclerViewClicklistener
    {
        void onClick(View v, int position);
    }
}
