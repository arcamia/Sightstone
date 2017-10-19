package com.sightstone.android.services;

import android.location.Location;

/**
 * System-private API for talking to the Sightstone service.
 *
 * {@hide}
 */
interface ISightStone {

	void flushLog();

    	/**
     	* Retrieve the name of the package of the calling 
     	* application. Check if it belongs to monitor list
     	* @param the package name of the calling process.
     	*/
	void checkPackageName(String packageName);
	boolean isBlackListed();
	Location answerWithFakeLocation(String provider);
}
