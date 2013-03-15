package com.donnfelker.android.bootstrap.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: nohono
 * Date: 13. 3. 15.
 * Time: 오후 12:00
 * To change this template use File | Settings | File Templates.
 */
public class StartupService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int onStartCommand(Intent intent, int flags , int startId){
        super.onStartCommand(intent, flags, startId);
        Log.d("monoboy", "onStartCommand");

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("monoboy", "service onCreate");


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("monoboy", "service onDestory");
    }
}
