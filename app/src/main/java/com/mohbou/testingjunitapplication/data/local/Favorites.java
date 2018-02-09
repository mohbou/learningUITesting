package com.mohbou.testingjunitapplication.data.local;

public interface Favorites {

    boolean get(String id);
    boolean toggle(String id);
}
