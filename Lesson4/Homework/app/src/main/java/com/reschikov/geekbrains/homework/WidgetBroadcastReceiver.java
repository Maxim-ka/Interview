package com.reschikov.geekbrains.homework;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WidgetBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final String action = intent.getAction();
		if (MyWidget.ACTION_LAUNCH_SERVICE.equals(action)) {
			Log.i("onReceive: ", action);
			boolean isLaunch = intent.getBooleanExtra("isLaunch", false);
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
}
