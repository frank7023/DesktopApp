package hades.org.desktopapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Hades on 16/9/17.
 */
public class TimeWidget extends AppWidgetProvider {
    private Timer timer;
    private AppWidgetManager appWidgetManager;
    private Context context;
    //将0～9的液晶数字图片定义成数组
    private int digits[] = {
            R.drawable.su01,
            R.drawable.su02,
            R.drawable.su03,
            R.drawable.su04,
            R.drawable.su05,
            R.drawable.su06,
            R.drawable.su07,
            R.drawable.su08,
            R.drawable.su09,
            R.drawable.su10,
    };
    //将显示小时、分钟秒钟的ImageView定义成数组
    private int digitViews[] = {
            R.id.time01,
            R.id.time02,
            R.id.time03,
            R.id.time04,
            R.id.time05,
            R.id.time06,
    };

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Toast.makeText(context, "--onUpdate--", Toast.LENGTH_SHORT).show();
        this.appWidgetManager = appWidgetManager;
        this.context = context;
        //定义计时器
        timer = new Timer();
        //启动周期性调度
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,1000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.time_layout);
                //定义SimpleDataFormat对象
                SimpleDateFormat df = new SimpleDateFormat("HHmmss");
                String timerstr = df.format(new Date());
                for ( int i = 0 ; i < timerstr.length();i++) {
                    //将第i个数字字符转换为对应的数字
                    int num = timerstr.charAt(i) - '0';
                    //将第i个数字设置对应的液晶数字
                    remoteViews.setImageViewResource(digitViews[i], digits[num]);
                }
                //将AppWidgetProvider子类实例包装成ComponentName对象
                ComponentName componentName = new ComponentName(context, TimeWidget.class);
                //更新
                appWidgetManager.updateAppWidget(componentName, remoteViews);
            }
        }
    };
}
