package com.example.dummyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class firstStoryCategory extends AppCompatActivity {

    TextView title;
    RecyclerView storyRec;
    StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_story_category);

        storyRec = findViewById(R.id.storyRecView);
        storyRec.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<StoryModel> options =
                new FirebaseRecyclerOptions.Builder<StoryModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("story"), StoryModel.class)
                        .build();

        adapter = new StoryAdapter(options);
        storyRec.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}