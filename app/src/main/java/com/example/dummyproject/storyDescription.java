package com.example.dummyproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class storyDescription extends Fragment {

    String title, desc;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public storyDescription() {
    }

    public storyDescription(String title, String desc) {

        this.title = title;
        this.desc = desc;

    }

    public static storyDescription newInstance(String param1, String param2) {
        storyDescription fragment = new storyDescription();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_story_description, container, false);

        TextView titleholder = view.findViewById(R.id.titleholder);
        TextView descholder = view.findViewById(R.id.descholder);

        titleholder.setText(title);
        descholder.setText(desc);

        return view;

    }
}