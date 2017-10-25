/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 *
 */
package com.sightstone.android.sightstoneservice.Utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class IntentHelper {
    Context mContext;

    public IntentHelper(Context context){
        mContext = context;
    }

    // Ask the cloud if <app> can use <function>
    public void sendPackageRequestPolicy(String packageName, String policyType){

        Intent askIntent = new Intent(SightStoneContract.ACTION_REQUEST_POLICY);
        askIntent.putExtra(SightStoneContract.PACKAGE_NAME,packageName);
        askIntent.putExtra(SightStoneContract.PACKAGE_POLICY,policyType);
        askIntent.setComponent(new ComponentName(SightStoneContract.TRANSPORT_APP,SightStoneContract.COMMUTE_COMPONENT));
        mContext.startService(askIntent);
    }

    // Ask the cloud if <app> can use <function>
    public void sendPackageRequestLocationData(){

        // send an Intent to Cargo service to ask for location data
        Intent askIntent = new Intent(SightStoneContract.ACTION_REQUEST_LOCATION);
        askIntent.putExtra("FeedData", "Location");
        askIntent.setType("text/plain");
        askIntent.setComponent(new ComponentName(SightStoneContract.TRANSPORT_APP,SightStoneContract.COMMUTE_COMPONENT));
        mContext.startService(askIntent);
    }

}
