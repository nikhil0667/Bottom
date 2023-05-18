package com.example.bottomnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class About extends Fragment {
    TextView textView;
    View v;
    // TODO: Rename parameter arguments, choose names that match
public static final String Arg1 = "arg1";
    public static final String Arg2 = "arg2";

    public About() {
        // Required empty public constructor
    }

    public static About getInstance(String value1,int value2) {
        About about = new About();
        Bundle bundle = new Bundle();
        bundle.putString(Arg1,value1);
        bundle.putInt(Arg2,value2);
about.setArguments(bundle);
        return new About();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_about, container, false);
        textView = v.findViewById(R.id.frag_about);

        if (getArguments() != null) {
            String name = getArguments().getString(Arg1);
            textView.setText(name);
        }else {
            textView.setText("Not include");
        }
        // Inflate the layout for this fragment
        return v;

    }
}