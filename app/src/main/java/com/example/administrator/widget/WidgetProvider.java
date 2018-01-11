package com.example.administrator.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017-11-24.
 */

public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(intent.getAction())){

        }
    }

    /**
     * 위젯 갱신주기에 따라 호출된다
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        int count = appWidgetIds.length;
        for (int i = 0; i < count; i++) {
            updateWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    /**
     * 위젯 업데이트
     */
    private void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetIds){
        // 위젯 레이아웃 가져오기
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
        long now = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String value = sdf.format(now);
        views.setTextViewText(R.id.textView, value);
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }
}
