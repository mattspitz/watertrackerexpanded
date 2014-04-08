package com.paddy.android.watertracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiveBoot extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		long temporaryInterval = 30000; // FIXME every 30 seconds
		HandlerNotifications.configureRepeatingAlarm(context, temporaryInterval);
	}
}
