package com.sightstone.android.sightstoneservice;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.sightstone.android.services.ISightStone;

class ISightStoneServiceImpl extends ISightStone.Stub {
  private static final String TAG = "ISightStoneServiceImpl";
  private final Context context;

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

}
