package com.example.firstlesson;

import android.content.Context;
import android.content.SharedPreferences;
import static android.content.Context.MODE_PRIVATE;

/**
 * SharedFiles class
 */
public class SharedFiles {
    private SharedPreferences sharedPreferences;

    /**
     * Constructor класса SharedPreferences
     * @param context context of Activity or Fragment
     */
    public SharedFiles(Context context) {
        sharedPreferences = context.getSharedPreferences("DateTime", MODE_PRIVATE);
    }

    /**
     * Getter of SharedPreference's object
     * @return sharedPreferences object
     */
    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
