package com.sightstone.android.sightstoneservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.sightstone.android.services.ISightStone;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;

class ISightStoneServiceImpl extends ISightStone.Stub {
  private static final String TAG = "ISightStoneServiceImpl";
  private final Context context;
	SharedPreferences pref;

  ISightStoneServiceImpl(Context context) {
	this.context = context;
  }

  public void flushLog() throws RemoteException {
	if (this.context.checkCallingOrSelfPermission(Manifest.permission.CHECK_UID) != 
	    PackageManager.PERMISSION_GRANTED) {
      throw new SecurityException("Requires CHECK_UID permission");
    }
    Log.d(TAG, "Flushing Logs");
  }

    /**
     * Retrieve the name of the package of the calling
     * application. Check if it belongs to monitor list
     * @param the package name of the calling process.
     */
  public void checkPackageName(String packageName) {
	// send an Intent to Cargo service
	Intent sendIntent = new Intent();
	sendIntent.putExtra("PackageName", packageName);
	sendIntent.setPackage("com.example.wayne.simplesensor");
	sendIntent.setType("text/plain");
	context.startService(sendIntent);
  }

  public boolean isBlackListed() {

	SharedPreferences pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
	return pref.getBoolean("Policy", true);
	
  }

  /**
   * Return an fake Location object to the requesting process.
   * 
   * Instead of letting the real Location Manage retrieve the stored location,
   * we craft a fake one and let the requested process to have it.
   *
   * @param The string that indicates the location provider name
   * @param the Intent comes from that application
   */
  public Location answerWithFakeLocation(String provider) {

            	// send an Intent to Cargo service
		Intent sendIntent = new Intent();
		sendIntent.putExtra("FeedData", "Location");
		sendIntent.setPackage("com.example.wayne.simplesensor");
		sendIntent.setType("text/plain");
		context.startService(sendIntent);

	SharedPreferences pref = context.getSharedPreferences("MyPref", 0);

	// Setup a location object that contains fake altitude, longtitude
	// and latitude. The time attribute is the time this object got generated.
	// The remaining attributes are also made up so it appears to be similar
	// to the legitimate one
	Location location = new Location(provider);

	//Set the estimated accuracy of this location
	location.setAccuracy(10.0f);

	//Set the altitude, in meters above the WGS 84 reference ellipsoid.
	location.setAltitude(14.0);

	//Set the time of this fix, in elapsed real-time since system boot. 
	location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());

	//Sets the extra information associated with this fix to the given Bundle.
	Bundle mBundle = new Bundle();
	mBundle.putInt("satellites", 11);
	location.setExtras(mBundle);

	//Set the latitude, in degrees. 
	location.setLatitude(pref.getFloat("latitude", 4.0f));

	//Set the longitude, in degrees. 
	location.setLongitude(pref.getFloat("longitude", 2.0f));

	//Sets the name of the provider
	location.setProvider(provider);

	//Set the UTC time in milliseconds
	location.setTime(System.currentTimeMillis());

	return location;
  }

}
