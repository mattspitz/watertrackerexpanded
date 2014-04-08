package com.paddy.android.watertracker;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiveBoot extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// FIXME set the interval you actually want here
		long temporaryInterval = AlarmManager.INTERVAL_HOUR;
		HandlerNotifications.configureRepeatingAlarm(context, temporaryInterval);
	}
}
