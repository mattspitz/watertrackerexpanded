package com.paddy.android.watertracker;

import android.app.AlarmManager;
import android.app.Application;

public class WaterTrackerApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		// FIXME pick the interval you actually want here
		long temporaryInterval = AlarmManager.INTERVAL_HOUR;
		HandlerNotifications.configureRepeatingAlarm(this, temporaryInterval);
	}
}
