package com.mohbou.testingjunitapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mohbou.testingjunitapplication.data.local.RecipeStore;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recipes);
        RecipeStore recipeStore = new RecipeStore(this,"recipes");
        RecipeAdapter recipeAdapter = new RecipeAdapter(recipeStore);
        recyclerView.setAdapter(recipeAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
