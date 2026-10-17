package com.brewku.app.ads

/**
 * Konfigurasi Iklan Google AdMob untuk BrewKu
 *
 * Menggunakan ID Uji Coba Resmi dari Google AdMob.
 * Aman untuk dicoba berkali-kali tanpa risiko penalti.
 */
object AdConfig {
    // Official Test Banner ID
    const val BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/6300978111"

    // Official Test Interstitial ID
    const val INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

    // Aturan Frekuensi Interstitial:
    // 1. Muncul setelah menyelesaikan seduhan setiap BREWS_PER_AD kali
    const val BREWS_PER_AD = 2

    // 2. Jeda minimal antar interstitial (120 detik = 2 menit)
    const val MIN_INTERVAL_BETWEEN_ADS_MS = 120_000L
}
