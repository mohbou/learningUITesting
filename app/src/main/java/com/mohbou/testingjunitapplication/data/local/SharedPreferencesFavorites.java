package com.mohbou.testingjunitapplication.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesFavorites implements Favorites {

    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorite.xml", Context.MODE_PRIVATE);
    }
    @Override
    public boolean get(String id) {
        return pref.getBoolean(id, false);
    }

    public void put(String id, boolean favorite) {
        SharedPreferences.Editor editor = pref.edit();
        if (favorite) {
            editor.putBoolean(id, true);
        } else
            editor.remove(id);
        editor.apply();
    }

    @Override
    public boolean toggle(String id) {
        boolean favorite = get(id);
        put(id,!favorite);
        return !favorite;
    }
}
