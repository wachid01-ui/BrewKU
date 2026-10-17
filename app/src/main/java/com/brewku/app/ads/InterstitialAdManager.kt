package com.brewku.app.ads

import android.app.Activity
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class InterstitialAdManager(private val context: Context) {

    private var interstitialAd: InterstitialAd? = null
    private var isLoading = false
    private var completedBrewsCount = 0
    private var lastAdShownTimestamp = 0L

    init {
        loadAd()
    }

    fun loadAd() {
        if (isLoading || interstitialAd != null) return
        isLoading = true

        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            AdConfig.INTERSTITIAL_AD_UNIT_ID,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isLoading = false
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    isLoading = false
                }
            }
        )
    }

    /**
     * Dipanggil HANYA setelah pengguna menyelesaikan seduhan.
     * Tidak akan pernah memotong proses penyeduhan yang sedang berjalan.
     */
    fun showAfterBrewComplete(
        activity: Activity,
        onAdDismissed: () -> Unit
    ) {
        completedBrewsCount++
        val currentTime = System.currentTimeMillis()
        val timeSinceLastAd = currentTime - lastAdShownTimestamp

        val isCountReady = completedBrewsCount >= AdConfig.BREWS_PER_AD
        val isIntervalPassed = timeSinceLastAd >= AdConfig.MIN_INTERVAL_BETWEEN_ADS_MS
        val isAdAvailable = interstitialAd != null

        if (isCountReady && isIntervalPassed && isAdAvailable) {
            val ad = interstitialAd
            ad?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    interstitialAd = null
                    lastAdShownTimestamp = System.currentTimeMillis()
                    completedBrewsCount = 0
                    loadAd()
                    onAdDismissed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    interstitialAd = null
                    loadAd()
                    onAdDismissed()
                }
            }
            ad?.show(activity)
        } else {
            onAdDismissed()
            if (interstitialAd == null && !isLoading) {
                loadAd()
            }
        }
    }
}
