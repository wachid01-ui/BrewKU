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
    // 1. Muncul setelah menyelesaikan seduhan (diatur ke 1 agar langsung tampil saat testing)
    const val BREWS_PER_AD = 1

    // 2. Jeda minimal antar interstitial (0 saat testing agar selalu muncul, naikkan saat rilis)
    const val MIN_INTERVAL_BETWEEN_ADS_MS = 0L
}
