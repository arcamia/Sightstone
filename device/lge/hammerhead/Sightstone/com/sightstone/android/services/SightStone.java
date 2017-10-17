package com.sightstone.android.services;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Process;
import android.util.Log;

public class SightStone {
    private static final String TAG = "SightStone";
    private static final String REMOTE_SERVICE_NAME = ISightStone.class.getName();
    private final ISightStone mSightStone;

    public static SightStone getInstance() {
        return new SightStone();
    }

    private SightStone() {
        Log.d(TAG, "Connecting to ISightStone by name [" + REMOTE_SERVICE_NAME + "]");
        this.mSightStone = ISightStone.Stub.asInterface(ServiceManager.getService(REMOTE_SERVICE_NAME));
        if (this.mSightStone == null) {
	        throw new IllegalStateException("Failed to find ISightStone by name [" + REMOTE_SERVICE_NAME + "]");
        }
    } 

    public void flushLog() {
        try {
            Log.d(TAG, "Flushing logs");
            this.mSightStone.flushLog();
        } catch (RemoteException e) {
            throw new RuntimeException("Failed to flush log", e);
        }
    }

}
