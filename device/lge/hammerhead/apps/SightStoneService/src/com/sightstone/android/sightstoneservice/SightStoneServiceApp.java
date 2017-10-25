/**
* The class initiate the server service on client side.
* When this application starts, it connects the service that runs
* in the framework layer with the worker logic in application layer
*
*/
package com.sightstone.android.sightstoneservice;

import com.sightstone.android.sightstoneservice.Utils.SightStoneContract;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;
import com.sightstone.android.services.ISightStone;

/**
 * Similar to other system services, SightStone does not directly interact
 * with the application layer. It is through this interface that the service
 * can be accessed from other applications. 
 *
 */
public class SightStoneServiceApp extends Application {

    private static final String REMOTE_SERVICE_NAME = ISightStone.class.getName();
    private ISightStoneServiceImpl serviceImpl;

    public void onCreate() {
        super.onCreate();
        this.serviceImpl = new ISightStoneServiceImpl(this);
        ServiceManager.addService(REMOTE_SERVICE_NAME, this.serviceImpl);
        Log.d(SightStoneContract.TAG_APP, "Registered [" + serviceImpl.getClass().getName() + "] as [" + REMOTE_SERVICE_NAME + "]");
    }

    public void onTerminate() {
        super.onTerminate();
        Log.d(SightStoneContract.TAG_APP, "Terminated");
    }
}
