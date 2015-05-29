package com.example.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	NotificationManager notificationManager	;
	NotificationCompat.Builder builder;
	RemoteViews bigView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bigView = new RemoteViews(getApplicationContext().getPackageName(),R.layout.notification_layout_big);
		bigView.setImageViewResource(R.id.image, R.drawable.ic_launcher);
	
		bigView.setTextViewText(R.id.title, ("Custom notification"));
		bigView.setTextViewText(R.id.text, 
				"This is a custom layout "+
		 		"This is a custom layout "+
				"This is a custom layout " +
		 		"This is a custom layout "+
				"This is a custom layout " /*+ 
		 		"This is a custom layout "+
				"This is a custom layout "+
		 		"This is a custom layout "+
				"This is a custom layout "+
		 		"This is a custom layout "+
				"This is a custom layout "+
		 		"This is a custom layout "+
				"This is a custom layout "*/
				);
		Log.e(Constants.ERROR_TAG,"1");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("NewApi")
	public void startNotification(View v)
	{
		Log.e(Constants.ERROR_TAG,"Start Notification Pressed");


		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle("Notification Alert, Click Me!!!!");
		mBuilder.setContentText("Each of the notify methods takes an int id parameter and  your app. If you call one of the notify methods with a (tag, id) pair that is currently active and a new set of notification parameters, it will be updated. For example, if you pass a new status bar icon, S");
		//mBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText("wefgfsasdasdasdasddg")).build();
		
		
		
		NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
		       String[] events = new String[10];
		       events[0] = new String("1) Message for implicit intent");
		       events[1] = new String("2) big view Notification");
		       events[2] = new String("3) How Much Big");
		       events[3] = new String("4) Fourth one");
		       events[4] = new String("5) Fifth One");
		       events[5] = new String("6) Sixth One !!!");
		       events[6] = new String("7) Seventh One!!!");
		       events[7] = new String("8) Eighth One!!!");
		       events[8] = new String("9) Ninth One");
		       events[9] = new String("10) Tenth One!!!");
		  
		       
		       // Sets a title for the Inbox style big view
		       inboxStyle.setBigContentTitle("More Details:");
		       // Moves events into the big view
		       for (int i=0; i < events.length; i++) {
		          inboxStyle.addLine(events[i]);
		       }
	       mBuilder.setStyle(inboxStyle).build();

		
	       mBuilder.setContent(bigView);
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		mNotificationManager.notify(0, mBuilder.build());

		
//		NotificationCompat.Builder mBuilder =
//		        new NotificationCompat.Builder(this)
//		        .setSmallIcon(R.drawable.ic_stat_notification)
//		        .setContentTitle(getString(R.string.notification))
//		        .setContentText(getString(R.string.ping))
//		        .setDefaults(Notification.DEFAULT_ALL) // requires VIBRATE permission
//		        /*
//		         * Sets the big view "big text" style and supplies the
//		         * text (the user's reminder message) that will be displayed
//		         * in the detail area of the expanded notification.
//		         * These calls are ignored by the support library for
//		         * pre-4.1 devices.
//		         */
//		        .setStyle(new NotificationCompat.BigTextStyle().bigText("asdasdasdfjkzsdkjsdfgsdfbgjfguidfbg"));


	}
}
