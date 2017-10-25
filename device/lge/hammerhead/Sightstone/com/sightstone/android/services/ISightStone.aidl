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
    String checkPackageName(String action);
    String getJsonReply (String fileName);
    void requestLocationData();
    Location answerWithFakeLocation(String provider);
}
