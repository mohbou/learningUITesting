package com.mohbou.testingjunitapplication.data.local;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavorites implements Favorites {
    private final Map<String,Boolean> map= new HashMap<>();
    @Override
    public boolean get(String id) {
        final Boolean value = map.get(id);
        return value ==null ? false : value;
    }

    @Override
    public boolean toggle(String id) {
        final Boolean value = get(id);
        put(id,!value);
        return !value;
    }

    public void put(String id,Boolean value) {
        map.put(id,value);
    }

    public void clear() {
        map.clear();
    }
}
