package com.example.setek;

import android.content.Context;
import android.content.Intent;

import com.example.setek.main.MainActivity;

public class ActivityUtil {

    private Context context;

    public ActivityUtil(Context context) {
        this.context = context;
    }

    public void startMainActivity() {
        this.context.startActivity(new Intent(context, MainActivity.class));
    }
}
