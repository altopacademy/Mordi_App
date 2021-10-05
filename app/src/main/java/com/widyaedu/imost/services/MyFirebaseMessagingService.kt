package com.widyaedu.imost.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.widyaedu.imost.BuildConfig
import com.widyaedu.imost.R

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (BuildConfig.DEBUG) {
            Log.e("fatal firebase", Gson().toJson(remoteMessage.data))
        }

        val title = baseContext.resources.getString(R.string.app_name)
        val mNotificationId = 105
        val inboxStyle = NotificationCompat.BigTextStyle()

        val notificationManager =
            baseContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nc = NotificationChannel("125", title, NotificationManager.IMPORTANCE_HIGH)
            nc.description = "IMost Notification"
            nc.enableLights(true)
            nc.lightColor = Color.YELLOW
            notificationManager.createNotificationChannel(nc)
        }
        val mBuilder = NotificationCompat.Builder(baseContext, "121")

        mBuilder
            .setColor(ContextCompat.getColor(this, R.color.primary))
            .setWhen(System.currentTimeMillis())
            .setAutoCancel(true)
            .setContentTitle(
                if (remoteMessage.notification != null) {
                    remoteMessage.notification?.title
                } else {
                    remoteMessage.data["title"]
                })
            .setStyle(inboxStyle)
            .setContentText(
                if (remoteMessage.notification != null) {
                    remoteMessage.notification?.title
                } else {
                    remoteMessage.data["message"]
                })
            .build()

        try {
            notificationManager.notify(mNotificationId, mBuilder.build())
        } catch (e: Exception) {
        }
    }

}