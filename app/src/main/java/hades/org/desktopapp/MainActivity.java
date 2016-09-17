package hades.org.desktopapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
        开发桌面控件只需要定义一个AppWidgetProvider的子类，并重写他的一些方法即可
        一般来说是重写onUpdate()方法

        onUpdate()方法负责更新桌面控件的方法，
        onDeleted():当一个或多个桌面空间被删除时回调该方法
        onEnabled():当接收到ACTION_APPWIDGET_ENABLED Broadcast时回调该方法
        onDisabled():当接受到ACTION_APPWIDGET_DISABLED Broadcast时回调该方法

        开发步骤：
        1、创建一个RemoteViews对象，创建该对象时可以指定加载指定的界面布局文件
        2、如果需要改变上一步所加载的界面布局文件的内容，则可通过RemoteViews对象进行修改
        3、创建一个ComponentName对象。
        4、调用AppWidgetManager对象更新桌面控件

        之后要在清单文件里面声明开发好的AppWidgetProvider的子类，因为其本身就是继承BroadcastReceiver

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
