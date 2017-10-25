package com.sightstone.android.services;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Process;
import android.util.Log;

import android.content.Intent;

import android.location.Location;

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

    /**
     * Retrieve the name of the package of the calling
     * application. Check if it belongs to monitor list
     * @param the package name of the calling process.
     */
    public String checkPackageName(String action) {
        try {
            Log.d(TAG, "Checking the package name");
            return this.mSightStone.checkPackageName(action);
        } catch (RemoteException e) {
            throw new RuntimeException("Failed checking the package name", e);
        }
    }

    public String getJsonReply (String fileName) {
        try {
            Log.d(TAG, "Convert file to JSON Object");
            return this.mSightStone.getJsonReply(fileName);
        } catch (RemoteException e) {
            throw new RuntimeException("Failed Convert file to JSON Object", e);
        }
    }

    public void requestLocationData(){
        try {
            Log.d(TAG, "Requesting location data");
            this.mSightStone.requestLocationData();
        } catch (RemoteException e) {
            throw new RuntimeException("Failed Requesting location data", e);
        }
    }

    public Location answerWithFakeLocation(String provider) {
        try {
            Log.d(TAG, "Answer with fake location data");
            return this.mSightStone.answerWithFakeLocation(provider);
        } catch (RemoteException e) {
            throw new RuntimeException("Failed Answer with fake location data", e);
        }
    }
}
