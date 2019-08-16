package com.reschikov.geekbrains.homework;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static androidx.core.app.NotificationCompat.PRIORITY_MAX;

public class MyService extends Service {

	private int messageId;

	@Override
	public void onCreate() {
		super.onCreate();
		makeNote(getBaseContext(), "Service ", "onCreate() ");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		makeNote(getBaseContext(), "Service ", "onStartCommand() ");
		return super.onStartCommand(intent, flags, startId);
	}

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		makeNote(getBaseContext(), "Service ", "onDestroy() ");
	}

	private void makeNote (Context context, String title, String message) {
		NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "2")
			.setSmallIcon(R.drawable.ic_sentiment_satisfied_black_24dp)
			.setContentTitle(title)
			.setContentText(message)
			.setPriority(PRIORITY_MAX);

		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(messageId++, builder.build());
	}
}
