package hades.org.desktopapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by Hades on 16/9/17.
 */
public class ImageWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //1 加载制定界面的布局文件,创建RemoteViews对象
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.activity_main);
        //2 为show ImageView设置图片
        remoteViews.setImageViewResource(R.id.show, R.drawable.logo);
        //3 将AppWidgetProvider的子类实例包装成ComponentName对象
        ComponentName componentName = new ComponentName(context, ImageWidget.class);
        //这段代码可以为控件添加点击启动的PendingIntent
        Intent intent = new Intent(context.getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0x123, intent,
                0);
        remoteViews.setOnClickPendingIntent(R.id.show,pendingIntent);

        //4 调用AppWidgetManager对象将remoteViews添加到ComponentName中
        appWidgetManager.updateAppWidget(componentName, remoteViews);


    }


}
