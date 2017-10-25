package com.sightstone.android.sightstoneservice;

import com.sightstone.android.sightstoneservice.Utils.SightStoneContract;
import com.sightstone.android.sightstoneservice.Utils.PackageHelper;
import com.sightstone.android.sightstoneservice.Utils.IntentHelper;
import com.sightstone.android.sightstoneservice.Utils.FileHelper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;

import com.sightstone.android.services.ISightStone;

import android.content.Intent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.content.ComponentName;
import android.os.Binder;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * This is the core implementation of SightStone. The following code represents
 * the actual functions that other processes from appication layer are able to use
 * upon requesting an instance of SightStone service
 */
class ISightStoneServiceImpl extends ISightStone.Stub {

    private final Context mContext;
    private PackageHelper mPackageHelper;
    private IntentHelper mIntentHelper;
    private FileHelper mFileHelper;

    ISightStoneServiceImpl(Context context) {
        mContext = context;
    }

    public void flushLog() throws RemoteException {
        if (mContext.checkCallingOrSelfPermission(Manifest.permission.CHECK_UID) !=
                PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException("Requires CHECK_UID permission");
        }
        Log.d(SightStoneContract.TAG_IMPL, "Flushing Logs");
    }

    /**
     * Retrieve the name of the package of the calling
     * application. Check if it belongs to monitor list
     *
     * @param the package name of the calling process.
     */
    public String checkPackageName(String action) {
        // send an Intent to Cargo service
	String answer="";
	mPackageHelper = new PackageHelper(mContext);
        String callingPackageName = mPackageHelper.getPackageName();
	
	mIntentHelper = new IntentHelper(mContext);
	mIntentHelper.sendPackageRequestPolicy(callingPackageName, action);

	mFileHelper = new FileHelper(mContext);
	JSONObject newJson = mFileHelper.getJsonFromFile(callingPackageName+"_"+action+".json");

	try {
		JSONObject nextJson = newJson.getJSONObject(callingPackageName);
		answer = nextJson.getString(action);
		Log.d("CANWEGETIT", nextJson.getString(action));
		return nextJson.getString(action);
	} catch (JSONException e){
		e.printStackTrace();
	}
        return answer;
    }

    public String getJsonReply (String fileName) {
        // send an Intent to Cargo service
	//mFileHelper = new FileHelper(mContext);
	//JSONObject newJson = mFileHelper.getJsonFromFile(fileName);
	return "holon";
	//return newJson.toString();
    }

    public void requestLocationData() {
	
	// notify the worker application that a set of location data is needed
        mIntentHelper = new IntentHelper(mContext);
	mIntentHelper.sendPackageRequestLocationData();
    }

    /**
     * Return an fake Location object to the requesting process.
     * <p>
     * Instead of letting the real Location Manage retrieve the stored location,
     * we craft a fake one and let the requested process to have it.
     *
     * @param The string that indicates the location provider name
     * @param the Intent comes from that application
     */
    public Location answerWithFakeLocation(String provider) {

        // Setup a location object that contains fake altitude, longitude
        // and latitude. The time attribute is the time this object got generated.
        // The remaining attributes are also made up so it appears to be similar
        // to the legitimate one
        Location location = new Location(provider);

        //Set the time of this fix, in elapsed real-time since system boot. 
        location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());

        //Sets the extra information associated with this fix to the given Bundle.
        Bundle mBundle = new Bundle();
        mBundle.putInt("satellites", 11);
        location.setExtras(mBundle);

        //Sets the name of the provider
        location.setProvider(provider);

        //Set the UTC time in milliseconds
        location.setTime(System.currentTimeMillis());

	// Acquire the Location data from server
	requestLocationData();

	try {
		JSONObject newJson = mFileHelper.getJsonFromFile(SightStoneContract.LOCATION_FILE);
		JSONObject nextJson = newJson.getJSONObject("Location Properties");

        	//Set the estimated accuracy of this location
        	location.setAccuracy((float)nextJson.getDouble("Accuracy"));

        	//Set the altitude, in meters above the WGS 84 reference ellipsoid.
        	location.setAltitude(nextJson.getDouble("Altitude"));

		//Set the latitude, in degrees. 
		location.setLatitude(nextJson.getDouble("Latitude"));

		//Set the longitude, in degrees. 
		location.setLongitude(nextJson.getDouble("Longitude"));

		//Set the Set the speed, in meters/second over ground. 
		location.setSpeed((float)nextJson.getDouble("Speed"));

		//Set the bearing, in degrees. 
		location.setBearing((float)nextJson.getDouble("Bearing"));

	} catch (JSONException e){
		e.printStackTrace();
	}
        return location;
    }

}
