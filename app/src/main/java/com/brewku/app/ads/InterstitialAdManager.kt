package com.brewku.app.ads

import android.app.Activity
import android.content.Context
import android.util.Log
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
        if (isLoading || interstitialAd != null) {
            Log.d(TAG, "Ad already loaded or loading in progress.")
            return
        }
        isLoading = true
        Log.d(TAG, "Requesting Interstitial Ad from AdMob...")

        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            context,
            AdConfig.INTERSTITIAL_AD_UNIT_ID,
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                    isLoading = false
                    Log.d(TAG, "Interstitial Ad successfully loaded and cached in memory!")
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                    isLoading = false
                    Log.e(TAG, "Interstitial Ad failed to load: ${loadAdError.message} (code: ${loadAdError.code})")
                }
            }
        )
    }

    /**
     * Dipanggil setelah pengguna menyelesaikan seduhan.
     * Tidak akan pernah memotong proses timer penyeduhan yang sedang berjalan.
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

        Log.d(TAG, "Attempting to show interstitial: count=$completedBrewsCount (req=${AdConfig.BREWS_PER_AD}), intervalPassed=$isIntervalPassed, isAdAvailable=$isAdAvailable")

        if (isCountReady && isIntervalPassed && isAdAvailable) {
            val ad = interstitialAd
            ad?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdShowedFullScreenContent() {
                    Log.d(TAG, "Interstitial Ad is now showing full screen.")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(TAG, "Interstitial Ad dismissed by user.")
                    interstitialAd = null
                    lastAdShownTimestamp = System.currentTimeMillis()
                    completedBrewsCount = 0
                    loadAd()
                    onAdDismissed()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.e(TAG, "Failed to show interstitial ad: ${adError.message}")
                    interstitialAd = null
                    loadAd()
                    onAdDismissed()
                }
            }
            ad?.show(activity)
        } else {
            Log.d(TAG, "Ad conditions not met or ad not ready yet, skipping to next action.")
            onAdDismissed()
            if (interstitialAd == null && !isLoading) {
                loadAd()
            }
        }
    }

    companion object {
        private const val TAG = "BrewKuAdMob"
    }
}
