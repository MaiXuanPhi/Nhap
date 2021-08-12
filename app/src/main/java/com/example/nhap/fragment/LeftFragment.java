package com.example.nhap.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nhap.R;

public class LeftFragment extends Fragment {

    public EditText ed;

    public LeftFragment() {
        // Required empty public constructor
    }

    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt_fr1 = view.findViewById(R.id.bt_fr1);
        Button bt_fr2 = view.findViewById(R.id.bt_fr2);
        Button bt_ok = view.findViewById(R.id.bt_ok);
        ed = view.findViewById(R.id.ed_lfr1);

        bt_fr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.rightfragment,RightFragment.newInstance()).commit();
            }
        });

        bt_fr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.rightfragment,RightFragment2.newInstance()).commit();
            }
        });

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                String chuoi = ed.getText().toString();
                RightFragment2 rightFragment2 = (RightFragment2) fragmentManager.findFragmentById(R.id.rightfragment);
                rightFragment2.tv.setText(chuoi);
            }
        });

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_left, container, false);
    }
}