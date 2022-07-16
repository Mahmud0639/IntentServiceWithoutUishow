package com.manuni.serviceintentone;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = "MyTag";

    public MyIntentService() {
        super("MyIntentService");
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: myIntentService called.");
        Log.d(TAG, "onCreate: Thread name : "+Thread.currentThread().getName());
    }

    // in intent service there is no need to call stop service or stop self. It will automatically stop it's services after completing all task
    // but in other service always starts again it's task after completing it's task one time and so on
    // in onCreate method every task will run in the main thread, in onHandleIntent every task will run in the background thread, in onDestroy every task will run in the main thread.


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: myIntentService called.");
        Log.d(TAG, "onHandleIntent: Thread name : "+Thread.currentThread().getName());
        String songName = intent.getStringExtra(MainActivity.MESSAGE_KEY);
        downloadSong(songName);
    }
    private void downloadSong(final String songName){
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downloadSong: "+songName+" downloaded.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: myIntentService called.");
        Log.d(TAG, "onDestroy: Thread name : "+Thread.currentThread().getName());
    }
}