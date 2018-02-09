package com.mohbou.testingjunitapplication.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.mohbou.testingjunitapplication.R;
import com.mohbou.testingjunitapplication.TestRecipeApplication;
import com.mohbou.testingjunitapplication.data.local.InMemoryFavorites;
import com.mohbou.testingjunitapplication.ui.RecipeActivity;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private  InMemoryFavorites favorites =null ;

    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();

        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public  RecipeRobot launch( ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;

    }
    public RecipeRobot noTitle() {
        return  checkIsHidden(R.id.announcement);
    }

    public RecipeRobot description(@StringRes int stringId ) {

        return checkViewHasText(R.id.description,stringId);
    }
    public RecipeRobot setFavorite(String id) {
        favorites.put(id,true);
        return this;
    }

    public  RecipeRobot launch( ActivityTestRule rule,String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,id);
        rule.launchActivity(intent);

        return this;
    }

public RecipeRobot isFavorite() {
        return checkIsSelected(R.id.announcement);
}

    }
