package com.example.myapplication2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val countdownValue = intent.getIntExtra("COUNTDOWN_VALUE", 0)
        startCountdown(countdownValue)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun startCountdown(countdownValue: Int) {
        GlobalScope.launch {
            for (i in countdownValue downTo 1) {
                Log.d("CountdownService", "Countdown: $i")
                delay(1000)
            }
        }
    }

}

