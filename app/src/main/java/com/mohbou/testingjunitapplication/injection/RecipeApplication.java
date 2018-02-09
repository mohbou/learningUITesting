package com.mohbou.testingjunitapplication.injection;

import android.app.Application;

import com.mohbou.testingjunitapplication.data.local.Favorites;
import com.mohbou.testingjunitapplication.data.local.SharedPreferencesFavorites;

public class RecipeApplication extends Application {
   private Favorites favorites = null;

   public Favorites getFavorites() {
   if(favorites ==null) {
       favorites = new SharedPreferencesFavorites(this);
   }

   return favorites;
   }

}
