package com.mohbou.testingjunitapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohbou.testingjunitapplication.data.local.RecipeStore;
import com.mohbou.testingjunitapplication.data.model.Recipe;
import com.mohbou.testingjunitapplication.ui.RecipeActivity;


public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore recipeStore;

    public RecipeAdapter(RecipeStore recipeStore) {
        this.recipeStore = recipeStore;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        final Recipe recipe = recipeStore.recipes.get(position);
        holder.textView.setText(recipe.title);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.textView.getContext();
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra(RecipeActivity.KEY_ID,recipe.id);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeStore.recipes.size();
    }
}
