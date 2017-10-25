package com.sightstone.android.sightstoneservice;

import android.app.IntentService;
import android.content.Intent;

import android.util.Log;

import com.sightstone.android.sightstoneservice.Utils.SightStoneContract;
import com.sightstone.android.sightstoneservice.Utils.FileHelper;

public class CommunicationService extends IntentService {

    FileHelper fileHelper;
    public CommunicationService() {
        super("CommunicationService");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {

        switch (workIntent.getAction()) {
            // got the policy for the application
            case SightStoneContract.APPLY_POLICY:
                // Convert data to json format
                StringBuilder answer = new StringBuilder();
                answer.append("{ \""+workIntent.getStringExtra("packageName")+"\":{");
                answer.append("\"policy\":" + workIntent.getStringExtra("policy") + ",");
                answer.append("\"verdict\":" + workIntent.getStringExtra("verdict") + "}}");

                fileHelper = new FileHelper(getApplicationContext());
                fileHelper.saveJsonToFile(answer,workIntent.getStringExtra("packageName")+"_"+workIntent.getStringExtra("policy")+".json");
		break;

            // got the new location data to update
            case SightStoneContract.UPDATE_LOCATION:
                // Convert data to json format
                StringBuilder locdata = new StringBuilder();
		locdata.append(workIntent.getStringExtra("data"));

                fileHelper = new FileHelper(getApplicationContext());
                fileHelper.saveJsonToFile(locdata,SightStoneContract.LOCATION_FILE);
		break;
        }

    }

}
