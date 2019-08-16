package com.reschikov.geekbrains.homework;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class MyWidget extends AppWidgetProvider {

	public static final String ACTION_LAUNCH_SERVICE = "com.reschikov.geekbrains.homework.ACTION_LAUNCH_SERVICE";
	private static boolean isLaunch;

	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
		Log.i("onEnabled: ", ACTION_LAUNCH_SERVICE);
	}

	static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId, String message){
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.my_widget);

		isLaunch = !isLaunch;
		Intent intent = new Intent(context, MyWidget.class);
		intent.setAction(ACTION_LAUNCH_SERVICE);

		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		remoteViews.setOnClickPendingIntent(R.id.widget_button, pendingIntent);
		remoteViews.setTextViewText(R.id.widget_text, message);

		appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Log.i("onUpdate: ", ACTION_LAUNCH_SERVICE);
		for (int appWidgetId : appWidgetIds) {
			updateWidget(context, appWidgetManager,appWidgetId, null);
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		Log.i("onReceive: ", "MyWidget");
		final String action = intent.getAction();
		if (MyWidget.ACTION_LAUNCH_SERVICE.equals(action)) {
			String message;
			if (isLaunch){
				context.startService(new Intent(context, MyService.class));
				message = "служба запущена";
			}else {
				context.stopService(new Intent(context, MyService.class));
				message = "служба остановлена";
			}
			AppWidgetManager appWidgetManager =  AppWidgetManager.getInstance(context);
			int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, MyWidget.class));
			for (int appWidgetId : appWidgetIds) {
				MyWidget.updateWidget(context, appWidgetManager, appWidgetId, message);
			}
		}
	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		Log.i("onDeleted: ", ACTION_LAUNCH_SERVICE);
	}

	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
		Log.i("onDisabled: ", ACTION_LAUNCH_SERVICE);
		if (isLaunch) context.stopService(new Intent(context, MyService.class));
	}
}
