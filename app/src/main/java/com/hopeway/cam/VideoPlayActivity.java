package com.hopeway.cam;

import android.app.Activity;
import android.os.Bundle;

public class VideoPlayActivity extends Activity {
    @Override protected void onCreate(Bundle s) {
        super.onCreate(s); setContentView(R.layout.activity_video);
        setTitle(getIntent().getStringExtra("name"));
    }
}