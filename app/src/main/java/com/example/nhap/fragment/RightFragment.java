package com.example.nhap.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhap.R;

import java.util.ArrayList;


public class RightFragment extends Fragment {

    public ArrayList<FragmentObject> list = new ArrayList<>();
    public RecyclerView rc;

    public RightFragment() {
        // Required empty public constructor
    }

    public static RightFragment newInstance() {
        RightFragment fragment = new RightFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc = view.findViewById(R.id.rc);

        list.add(new FragmentObject(19,"Phi"));
        list.add(new FragmentObject(20,"Tuan"));
        list.add(new FragmentObject(29,"Nhat"));
        list.add(new FragmentObject(19,"Phi"));
        list.add(new FragmentObject(20,"Tuan"));
        list.add(new FragmentObject(29,"Nhat"));
        list.add(new FragmentObject(19,"Phi"));
        list.add(new FragmentObject(20,"Tuan"));
        list.add(new FragmentObject(29,"Nhat"));
        list.add(new FragmentObject(19,"Phi"));
        list.add(new FragmentObject(20,"Tuan"));
        list.add(new FragmentObject(29,"Nhat"));
        list.add(new FragmentObject(19,"Phi"));
        list.add(new FragmentObject(20,"Tuan"));
        list.add(new FragmentObject(29,"Nhat"));

        update(view);

    }

    public void update(View view){
        FragmentRecyclerView adapter = new FragmentRecyclerView(list);
        rc.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rc.setAdapter(adapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL);
        rc.addItemDecoration(itemDecoration);
    }
    public void xoa(int position){
        list.remove(position);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false);
    }
}