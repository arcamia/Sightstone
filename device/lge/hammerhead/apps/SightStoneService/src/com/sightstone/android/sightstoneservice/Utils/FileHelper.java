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

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.util.Log;

public class FileHelper {
    Context mContext;

    public FileHelper(Context context){
        mContext = context;
    }

    public File saveJsonToFile(StringBuilder data, String fileName){
        String path = SightStoneContract.TEMP_DIR;

        File directory = new File(path);
        if(!directory.exists()){
            directory.mkdirs();
        }

        File file = new File(path, fileName);

        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(data.toString().getBytes());
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return file;
    }

    public JSONObject getJsonFromFile(String fileName){
        JSONObject jsonObj = new JSONObject();
        String json = null;
        String path = SightStoneContract.TEMP_DIR;

        //boolean exist = false;
        //do{
            File file = new File(path+fileName);
            if(file.exists()){
		//        exist=true;
		//} while (!exist);

		try {
		    InputStream is = new FileInputStream(new File(path,fileName));
		    int size = is.available();
		    byte[] buffer = new byte[size];
		    is.read(buffer);
		    is.close();
		    json = new String(buffer, "UTF-8");
		} catch (IOException ex) {
		    ex.printStackTrace();
		    return null;
		}
		try {
		    jsonObj = new JSONObject(json);

		} catch (JSONException e){
		    e.printStackTrace();
		}
		return jsonObj;
	}
	return jsonObj;
	
    }
}

