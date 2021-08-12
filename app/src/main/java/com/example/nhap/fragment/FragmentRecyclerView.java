package com.example.nhap.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nhap.R;

import java.util.ArrayList;

public class FragmentRecyclerView extends RecyclerView.Adapter<FragmentRecyclerView.MyViewHolder>{
    ArrayList<FragmentObject> list;
    Context context;

    public FragmentRecyclerView(ArrayList<FragmentObject> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public FragmentRecyclerView(ArrayList<FragmentObject> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FragmentRecyclerView.MyViewHolder holder, int position) {
        holder.tv_ten.setText(list.get(position).ten);
        holder.tv_tuoi.setText(list.get(position).tuoi+"");
        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                list.remove(position);
//                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_ten, tv_tuoi;
        public ConstraintLayout main;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_ten = itemView.findViewById(R.id.tv_ten);
            tv_tuoi = itemView.findViewById(R.id.tv_tuoi);
            main = itemView.findViewById(R.id.main);
        }
    }
}
