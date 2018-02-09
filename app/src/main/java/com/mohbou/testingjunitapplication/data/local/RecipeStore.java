package com.mohbou.testingjunitapplication.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.mohbou.testingjunitapplication.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeStore {

    public final List<Recipe> recipes = new ArrayList<>();
    private final Map<String,Recipe> map = new HashMap<>();

    public RecipeStore(Context context,String directory) {
        List<InputStream> streams = getAssetSreams(context.getAssets(),directory);

        for(InputStream stream: streams) {
            Recipe recipe = Recipe.readFromStream(stream);
            if(recipe !=null) {
                recipes.add(recipe);
                map.put(recipe.id,recipe);
            }

        }
    }

    private static List<InputStream> getAssetSreams(AssetManager manager,String directory) {
        String [] fileNames = getFilenames(manager,directory);
        List<InputStream> streams = new ArrayList<>();
        for(String filename: fileNames) {
            File file = new File(directory,filename);
            try {
                InputStream stream = manager.open(file.getPath());
                if(stream !=null) {
                    streams.add(stream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       return streams;
    }

    private static String [] getFilenames(AssetManager manager,String directory) {
        if(directory ==null)
            return new String[0];

        try {
            return manager.list(directory);
        } catch (IOException e) {
            return new String[0];
        }
    }

    public Recipe getRecipe(String id) {
        return map.get(id);
    }
}
