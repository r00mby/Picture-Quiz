package com.example.picpick;

import android.content.Context;
import android.content.SharedPreferences;

public class UserProgressManager {
    private static final String PREF_NAME = "user_progress";
    private static final String KEY_HIGHEST_LEVEL = "highest_level_";

    private SharedPreferences preferences;

    public UserProgressManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getHighestLevel(String userName) {
        return preferences.getInt(KEY_HIGHEST_LEVEL + userName, 1);
    }

    public void setHighestLevel(String userName, int level) {
        if (level > getHighestLevel(userName)) {
            preferences.edit().putInt(KEY_HIGHEST_LEVEL + userName, level).apply();
        }
    }
}