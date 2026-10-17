package com.brewku.app

import android.app.Application
import com.google.android.gms.ads.MobileAds
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BrewKuApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Inisialisasi Google Mobile Ads SDK di thread IO agar startup tetap instan
        CoroutineScope(Dispatchers.IO).launch {
            try {
                MobileAds.initialize(this@BrewKuApp) {}
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
