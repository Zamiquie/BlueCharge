package com.example.activatebluewhencharginservicce;

import android.app.IntentService;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        //Lier au service
        mainActivity main = new mainActivity();

        Intent intent = new Intent(this,mainActivity.class);
        startService(intent);
        finish();
    }


}
