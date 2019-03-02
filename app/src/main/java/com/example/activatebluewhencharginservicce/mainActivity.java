package com.example.activatebluewhencharginservicce;

import android.app.IntentService;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


public class mainActivity extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    Intent filter = registerReceiver(null, new IntentFilter("android.hardware.usb.action.USB_STATE"));
                    if (filter.getExtras().getBoolean("connected")) {
                        bluetoothAdapter.enable();

                    } else {
                        bluetoothAdapter.disable();
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e){}
                }

            }
        }).start();




        return START_STICKY ;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }



    private boolean USBisConnected(){
        Intent intent = registerReceiver(null,new IntentFilter("android.hardware.usb.action.USB_STATE"));
        return intent.getExtras().getBoolean("connected");
    }

}






