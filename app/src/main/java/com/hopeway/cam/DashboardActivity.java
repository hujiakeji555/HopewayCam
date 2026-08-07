package com.hopeway.cam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends Activity {
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s); setContentView(R.layout.activity_placeholder);
        ((TextView)findViewById(R.id.pageTitle)).setText(R.string.dashboard);
    }
}