package io.github.dalwadi2.techround.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;


public class PreferenceHelper {

    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;

    public PreferenceHelper(Context ctx, String FileName) {
        prefs = ctx.getSharedPreferences(FileName, Context.MODE_PRIVATE);
    }

    public void clearAllPrefs() {
        prefs.edit().clear().apply();
    }

    @SuppressLint("CommitPrefEdits")
    public void initPref() {
        editor = prefs.edit();
    }

    public void ApplyPref() {
        editor.apply();
    }

    public void SaveStringPref(String key, String value) {
        editor.putString(key, value);
    }

    public String LoadStringPref(String key, String DefaultValue) {
        return prefs.getString(key, DefaultValue);
    }

    public String LoadStringPref(String key) {
        return prefs.getString(key, "");
    }

    public String loadAuthkey() {
        return prefs != null ? prefs.getString(Prefs.AUTH_KEY, "") : "";
    }

    public void SaveIntPref(String key, int value) {
        editor.putInt(key, value);
    }

    public int LoadIntPref(String key, int DefaultValue) {
        return prefs.getInt(key, DefaultValue);
    }

    public int LoadIntPref(String key) {
        return prefs.getInt(key, 0);
    }

    public void SaveBooleanPref(String key, boolean value) {
        editor.putBoolean(key, value);
    }

    public boolean LoadBooleanPref(String key, boolean DefaultValue) {
        return prefs.getBoolean(key, DefaultValue);
    }

    public void SaveSetPref(String key, Set<String> value) {
        editor.putStringSet(key, value);
    }

    public Set<String> LoadSetPref(String key, Set<String> value) {
        return prefs.getStringSet(key, value);
    }

   /* public void printVals() {
        for (Map.Entry<String, ?> entry : prefs.getAll().entrySet()) {
            Utils.Log("printVals: ", "key : " + entry.getKey() + " : " + entry.getValue().toString());
        }
    }*/

}