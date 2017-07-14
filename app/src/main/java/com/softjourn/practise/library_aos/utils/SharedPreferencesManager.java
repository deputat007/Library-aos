package com.softjourn.practise.library_aos.utils;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class SharedPreferencesManager {

    private interface Constants {
        String FILE_NAME = "library";

        String KEY_TOKEN = "TOKEN";
    }

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    public SharedPreferencesManager(@NonNull final Context context) {
        mSharedPreferences = context.getSharedPreferences(Constants.FILE_NAME, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void saveToken(@NonNull final String token) {
        mEditor.putString(Constants.KEY_TOKEN, token);

        saveChanges();
    }

    @Nullable
    public String getToken() {
        return mSharedPreferences.getString(Constants.KEY_TOKEN, null);
    }

    public void removeToken() {
        mEditor.remove(Constants.KEY_TOKEN);

        saveChanges();
    }

    public boolean isToken() {
        return mSharedPreferences.contains(Constants.KEY_TOKEN);
    }

    private void saveChanges() {
        mEditor.commit();
    }
}
