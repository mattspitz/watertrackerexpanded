package com.paddy.android.watertracker;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class HandlerNotifications extends IntentService {

	public static final String TAG = "NH";

	public HandlerNotifications() {
		super(HandlerNotifications.class.getSimpleName());
	}

	public static void configureRepeatingAlarm(Context context, long interval) {
		AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		Intent i = new Intent(context, HandlerNotifications.class);
		PendingIntent pi = PendingIntent.getService(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

		am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
				interval, interval, pi);
	}

	public void onHandleIntent(Intent intent) {
		notifyUser();
	}

	private void notifyUser() {
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

		notificationBuilder.setSmallIcon(R.drawable.water);
		notificationBuilder.setContentTitle("Water Tracker");
		notificationBuilder.setContentText("Time to drink!");
		notificationBuilder.setAutoCancel(true);

		Intent intent = new Intent(this, DrunkTodayActivity.class);

		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(DrunkTodayActivity.class);
		stackBuilder.addNextIntent(intent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

		notificationBuilder.setContentIntent(resultPendingIntent);

		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(0, notificationBuilder.build());
	}
}
