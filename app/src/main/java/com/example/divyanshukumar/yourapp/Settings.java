package com.example.divyanshukumar.yourapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        button = (Button)findViewById(R.id.statusBarButton);

        notification = new NotificationCompat.Builder(Settings.this);
        notification.setAutoCancel(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Build the notification
                notification.setOngoing(true);
                notification.setSmallIcon(R.drawable.ic_search);
                notification.setTicker("This is the ticker");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Search Your App");
                notification.setContentText("Click here to search for an app. DAMN Easy right! :)");

                Intent intent = new Intent(Settings.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(Settings.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                //Builds notification and issues it
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueID, notification.build());


            }
        });

    }



}
