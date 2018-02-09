package com.mohbou.testingjunitapplication;

import com.mohbou.testingjunitapplication.data.local.Favorites;
import com.mohbou.testingjunitapplication.data.local.InMemoryFavorites;
import com.mohbou.testingjunitapplication.injection.RecipeApplication;

public class TestRecipeApplication extends RecipeApplication {

private final Favorites favorites = new InMemoryFavorites();
    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
