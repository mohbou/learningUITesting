package com.mohbou.testingjunitapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mohbou.testingjunitapplication.R;
import com.mohbou.testingjunitapplication.data.local.Favorites;
import com.mohbou.testingjunitapplication.data.local.RecipeStore;
import com.mohbou.testingjunitapplication.data.model.Recipe;
import com.mohbou.testingjunitapplication.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";
    private TextView titleView;
    private TextView descriptionView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleView = findViewById(R.id.announcement);
        descriptionView = findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites =  app.getFavorites();
        boolean favorite = favorites.get(recipe.id);
        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result=favorites.toggle(recipe.id);
                titleView.setSelected(result);
            }
        });

        descriptionView.setText(recipe.description);

    }


}
