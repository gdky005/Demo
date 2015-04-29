package wq.gdky005.kaola.demo.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import wq.gdky005.kaola.demo.R;

/**
 * Created by WangQing on 15/4/15.
 */
public class UIHelp {

    /**
     * 在状态栏弹出通知
     *
     * @param context
     *            上下文
     * @param title
     *            状态栏显示的标题
     * @param text
     *            状态栏显示的文本内容
     * @param show_icon
     *            标题栏弹出的图片
     *
     */
    public static void showNotification(Context context, String title, String text,
                                        int show_icon,Intent in ) {
        try {
            Context app = context.getApplicationContext();
            NotificationManager nm = (NotificationManager) app
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            final int id = Integer.MAX_VALUE / 13 + 1;
            nm.cancel(id);

            long when = System.currentTimeMillis();

            // Notification的滚动提示
            String tickerText = text;
            int icon = show_icon;

            int notifyId = 20;

            // 创建Notifcation
            Notification notification = new Notification(icon, tickerText, notifyId);
//            if (isForbidCancel) {
//                notification.flags |= Notification.FLAG_AUTO_CANCEL;
//            } else {
//                notification.flags |= Notification.FLAG_ONGOING_EVENT;
//            }

            int precent = 0;
//            if (totalSize > 0) {
//                precent = (int) (currentSize * 100 / totalSize);
//            }


            NotificationCompat.BigTextStyle textStyle = new NotificationCompat.BigTextStyle();
            textStyle
                    .setBigContentTitle("BigContentTitle")
                    .setSummaryText("SummaryText")
                    .bigText(
                            "I am Big Texttttttttttttttttttttttttttttttttttttttttttt!!!!!!!!!!!!!!!!!!!......");
//            Notification notification = new NotificationCompat.Builder(context)
//                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
//                            R.mipmap.ic_launcher)).setSmallIcon(show_icon)
//                    .setTicker("showBigView_Text").setContentInfo("contentInfo")
//                    .setContentTitle("ContentTitle").setContentText("ContentText")
//                    .setStyle(textStyle)
//                    .setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)
//                    .build();


            // 创建RemoteViews用在Notification中
            RemoteViews contentView = new RemoteViews(context.getPackageName(),
                    R.layout.notification_view_layout);
            contentView.setTextViewText(R.id.notificationTitle, title);
            contentView.setTextViewText(R.id.downlaod_state, "测试状态哦");
            contentView.setTextViewText(R.id.notificationPercent, precent + "%");
            contentView.setProgressBar(R.id.notificationProgress, 100, precent,
                    false);

            notification.contentView = contentView;


            RemoteViews contentView1 = new RemoteViews(context.getPackageName(),
                    R.layout.notification_view_big_layout);
            contentView.setTextViewText(R.id.tvtv, "测试fsadfjljsalkfjlskafjlsajflsajfljlsaflsa");

            if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) //如果是4.1以上，可以支持通知了变大
                notification.bigContentView = contentView1;

            Intent intent = null;
            intent = new Intent();
//            if (file != null) {
//                intent = new Intent();
//                intent.setAction(android.content.Intent.ACTION_VIEW);
//                intent.setDataAndType(Uri.fromFile(file),
//                        "application/vnd.android.package-archive");
//            } else {
//                intent = new Intent();
//            }

            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    intent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.contentIntent = contentIntent;
            nm.notify(notifyId, notification);


//            bigTextNotify(context, show_icon, nm, id);


//            defaultNotify(context, title, text, show_icon, in, app, nm, id, when);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void defaultNotify(Context context, String title, String text, int show_icon, Intent in, Context app, NotificationManager nm, int id, long when) {
        Notification notification = new Notification(show_icon, text, when);
        PendingIntent pi = PendingIntent.getActivity(app, 0, new Intent(),
                0);
        notification.setLatestEventInfo(app, title, text, pi);
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        if(null != in){
            in.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, in, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.contentIntent = pendingIntent;
        }
        nm.notify(id, notification);

//        if (cancelTime > 0) {
//            Message msg = new Message();
//            // msg.what = MSG_CANCEL_NOTIFY;
//            msg.obj = nm;
//            msg.arg1 = id;
//            // UIHandler.sendMessageDelayed(msg, cancelTime, this);
//        }
    }

    private static void bigTextNotify(Context context, int show_icon, NotificationManager nm, int id) {
        NotificationCompat.BigTextStyle textStyle = new NotificationCompat.BigTextStyle();
        textStyle
                .setBigContentTitle("BigContentTitle")
                .setSummaryText("SummaryText")
                .bigText(
                        "I am Big Texttttttttttttttttttttttttttttttttttttttttttt!!!!!!!!!!!!!!!!!!!......");
        Notification notification = new NotificationCompat.Builder(context)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.ic_launcher)).setSmallIcon(show_icon)
                .setTicker("showBigView_Text").setContentInfo("contentInfo")
                .setContentTitle("ContentTitle").setContentText("ContentText")
                .setStyle(textStyle)
                .setAutoCancel(true).setDefaults(Notification.DEFAULT_ALL)
                .build();
        nm.notify(id, notification);
    }

    public static void cancelNotification(Context context, int notifyId) {
        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        nm.cancel(notifyId);
    }
}
