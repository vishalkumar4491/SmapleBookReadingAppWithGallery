package com.example.dummyproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageDetails extends Fragment {



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    String purl;

    public ImageDetails() {

    }

    public ImageDetails(String purl) {
        this.purl = purl;
    }

    public static ImageDetails newInstance(String param1, String param2) {
        ImageDetails fragment = new ImageDetails();
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

        View view = inflater.inflate(R.layout.fragment_image_details, container, false);

        ImageView imageholder = view.findViewById(R.id.imageholder);
        Glide.with(getContext()).load(purl).into(imageholder);


        imageholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.image_details, new R.id.wrapper).addToBackStack(null).commit();
                activity.getSupportFragmentManager().popBackStack();
            }
        });

        return view;

    }


}