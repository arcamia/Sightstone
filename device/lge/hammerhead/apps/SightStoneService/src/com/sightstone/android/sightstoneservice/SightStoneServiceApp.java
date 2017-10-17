package com.sightstone.android.sightstoneservice;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;
import com.sightstone.android.services.ISightStone;

public class CheckServiceApp extends Application {
  private static final String TAG = "SightStoneServiceApp";
  private static final String REMOTE_SERVICE_NAME = ISightStone.class.getName();
  private ISightStoneServiceImpl serviceImpl;

  public void onCreate() {
    super.onCreate();
    this.serviceImpl = new ISightStoneServiceImpl(this);
    ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
    Log.d(TAG, "Registered [" + serviceImpl.getClass().getName() + "] as [" + REMOTE_SERVICE_NAME + "]");
  }

  public void onTerminate() {
    super.onTerminate();
    Log.d(TAG, "Terminated");
  }
}
