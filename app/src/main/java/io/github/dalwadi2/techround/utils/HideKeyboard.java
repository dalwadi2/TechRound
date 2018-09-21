package io.github.dalwadi2.techround.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class HideKeyboard {
    private static final String TAG = HideKeyboard.class.getSimpleName();
    private Context activityContext;

    private HideKeyboard(Context context) {
        activityContext = context;
        View rootView = ((Activity) activityContext).getWindow().getDecorView().findViewById(android.R.id.content);
        setupUI(rootView);
    }

    private HideKeyboard(Context context, View view) {
        activityContext = context;
        setupUI(view);
    }

    public static void initialize(Context context) {
        new HideKeyboard(context);
    }

    public static void initialize(Context context, View view) {
        new HideKeyboard(context, view);
    }

    private void setupUI(View obj) {
        if (!(obj instanceof EditText)) {
            obj.setOnTouchListener((v, event) -> {
                hideSoftKeyboard();
                return false;
            });
        }
        if (obj instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) obj).getChildCount(); i++) {
                View innerView = ((ViewGroup) obj).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void hideSoftKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activityContext
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(
                    ((Activity) activityContext).getCurrentFocus().getWindowToken(), 0);

        } catch (Exception e) {
            Log.e(TAG, "hideSoftKeyboard: " + e.getMessage());
        }
    }
}