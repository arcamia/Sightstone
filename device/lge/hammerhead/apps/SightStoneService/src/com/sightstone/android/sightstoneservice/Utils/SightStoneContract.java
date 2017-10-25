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
/*
 * The file holds all the constants that SightStone service will use repeatively
 */

public final class SightStoneContract {

    /** Name of the implementation in client side */
    public static final String TAG_IMPL = "ISightStoneServiceImpl";

    /** Name of the worker application in client side */
    public static final String TAG_APP = "SightStoneServiceApp";

    /** Name of the middle application that briges the service and cloud storage */
    public static final String TRANSPORT_APP = "com.example.wayne.simplesensor";

    /** Name of the component of the middle application that briges the service and cloud storage */
    public static final String COMMUTE_COMPONENT = "com.example.wayne.simplesensor.CheckPackageNameService";

    /** The action call for the worker service to check if the application allowed or not */
    public static final String ACTION_REQUEST_POLICY = "com.sightstone.android.DEVICE_POLICY";

    /** The key with value is the name of the package in question */
    public static final String PACKAGE_NAME = "SightStonePackage";

    /** The key with value is the type of policy in question */
    public static final String PACKAGE_POLICY = "SightStonePolicy";

    /** The action wakes up the service to apply the policy */
    public static final String APPLY_POLICY = "com.simplesensor.android.APPLY_POLICY";

    /** Temporrary data path */
    public static final String TEMP_DIR = "/data/data/com.sightstone.android.services/files/tmp/";

    /** The action call for the worker service to get the falsified location data */
    public static final String ACTION_REQUEST_LOCATION = "com.sightstone.android.LOCATION_DATA";

    /** The action wakes up the service to apply new location data */
    public static final String UPDATE_LOCATION = "com.simplesensor.android.UPDATE_LOCATION";

    /** Name of the file that contains location data */
    public static final String LOCATION_FILE = "location_data.json";
}
