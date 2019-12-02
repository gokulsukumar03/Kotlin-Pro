package com.kotlin.demo.services

import android.app.Service
import android.content.ComponentCallbacks
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.res.Configuration
import android.net.Uri
import android.os.IBinder

/*
* 1) START_STICKY - in case if android stops our service forcefully, then restart service by sending intent null
2) START_NOT_STICKY - in case if android stops our service forcefully, then don't restart, until user restarts it.
3) START_REDELIVER_INTENT- in case if android stops our service forcefully, then restart service by sending re-sending the intent.*/
class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented") as Throwable
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun getApplicationInfo(): ApplicationInfo {
        return super.getApplicationInfo()
    }

    override fun checkCallingOrSelfPermission(permission: String): Int {
        return super.checkCallingOrSelfPermission(permission)
    }

    override fun checkCallingOrSelfUriPermission(uri: Uri?, modeFlags: Int): Int {
        return super.checkCallingOrSelfUriPermission(uri, modeFlags)
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        super.enforceCallingOrSelfPermission(permission, message)
    }

    override fun createDeviceProtectedStorageContext(): Context {
        return super.createDeviceProtectedStorageContext()
    }

    override fun unregisterComponentCallbacks(callback: ComponentCallbacks?) {
        super.unregisterComponentCallbacks(callback)
    }

}























