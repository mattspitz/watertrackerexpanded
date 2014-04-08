package com.paddy.android.watertracker;

import android.app.Application;
import android.util.Log;

public class WaterTrackerApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		long temporaryInterval = 5000L; // FIXME every 5 seconds
		HandlerNotifications.configureRepeatingAlarm(this, temporaryInterval);
	}
}
