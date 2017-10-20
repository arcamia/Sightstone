package com.sightstone.android.sightstoneservice;

import android.app.IntentService;
import android.content.Intent;

import android.content.SharedPreferences; 
import android.content.SharedPreferences.Editor;

import android.util.Log;

public class CommunicationService extends IntentService {

	SharedPreferences pref;

    public CommunicationService() {
        super("CommunicationService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {

        // Gets data from the incoming Intent
        if ( workIntent.getExtras().getBoolean("Policy") == true) {


		pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		Editor editor = pref.edit();
		editor.putBoolean("Policy", true);
		editor.commit();  

        } else if (workIntent.getExtras().getString("Answer") == "Location") {
		Float longtitude = workIntent.getExtras().getFloat("longtitude");
                Float latitude = workIntent.getExtras().getFloat("latitude");
		Log.d("DOES IT COME THROUGH?", longtitude.toString() + " - " + latitude.toString());

		pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
		Editor editor = pref.edit();
		editor.putFloat("longtitude", longtitude);
		editor.putFloat("latitude", latitude);
		editor.commit(); 
		
	}
        // Do work here, based on the contents of dataString

    }

}
