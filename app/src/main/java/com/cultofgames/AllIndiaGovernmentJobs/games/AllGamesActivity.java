package com.cultofgames.AllIndiaGovernmentJobs.games;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;


import com.cultofgames.AllIndiaGovernmentJobs.databinding.ActivityAllGamesBinding;

import java.util.ArrayList;

public class AllGamesActivity extends AppCompatActivity {

    private ArrayList<GameItems> allGamesList;
    private ActivityAllGamesBinding binding;
    private GameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllGamesBinding.inflate(getLayoutInflater());
        getWindow().setFlags(1024, 1024);
        setContentView(binding.getRoot());


        allGamesList = GamesList.allGames();
binding.btnBackGames.setOnClickListener(view -> {
    finish();
});

        adapter = new GameAdapter(this, allGamesList);
        binding.allGamesRecycler.setAdapter(adapter);
        binding.allGamesRecycler.setLayoutManager(new GridLayoutManager(this,4));


    }
}