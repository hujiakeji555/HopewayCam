package com.hopeway.cam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private List<CameraDevice> devices = new ArrayList<CameraDevice>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.nav_alarm).setOnClickListener(this);
        findViewById(R.id.nav_cloud).setOnClickListener(this);
        findViewById(R.id.nav_gallery).setOnClickListener(this);
        findViewById(R.id.nav_settings).setOnClickListener(this);
        findViewById(R.id.nav_dashboard).setOnClickListener(this);

        devices.add(new CameraDevice("001", "客厅摄像头", "192.168.1.100", "IPC", true, 85, 72));
        devices.add(new CameraDevice("002", "门口摄像头", "192.168.1.101", "IPC", true, 65, 50));
        devices.add(new CameraDevice("003", "后院摄像头", "192.168.1.102", "Solar", false, 0, 30));

        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new CameraAdapter(devices));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnAdd) startActivity(new Intent(this, AddDeviceActivity.class));
        else if (id == R.id.nav_alarm) startActivity(new Intent(this, AlarmListActivity.class));
        else if (id == R.id.nav_cloud) startActivity(new Intent(this, CloudServiceActivity.class));
        else if (id == R.id.nav_gallery) startActivity(new Intent(this, GalleryActivity.class));
        else if (id == R.id.nav_settings) startActivity(new Intent(this, SettingsActivity.class));
        else if (id == R.id.nav_dashboard) startActivity(new Intent(this, DashboardActivity.class));
    }

    class CameraAdapter extends BaseAdapter {
        List<CameraDevice> list;
        CameraAdapter(List<CameraDevice> list) { this.list = list; }
        public int getCount() { return list.size(); }
        public Object getItem(int i) { return list.get(i); }
        public long getItemId(int i) { return i; }
        public View getView(int i, View v, ViewGroup p) {
            if (v == null) v = getLayoutInflater().inflate(R.layout.item_camera, p, false);
            CameraDevice d = list.get(i);
            ((TextView)v.findViewById(R.id.name)).setText(d.name);
            TextView status = (TextView)v.findViewById(R.id.status);
            status.setText(d.online ? "在线" : "离线");
            status.setTextColor(d.online ? 0xFF4CAF50 : 0xFFBDBDBD);
            ((TextView)v.findViewById(R.id.signal)).setText("信号 " + d.signal + "%");
            final String dname = d.name;
            v.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, VideoPlayActivity.class);
                    intent.putExtra("name", dname);
                    startActivity(intent);
                }
            });
            return v;
        }
    }
}
