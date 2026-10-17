package com.brewku.app.data.repository

import com.brewku.app.data.model.BrewMethod
import com.brewku.app.data.model.BrewStep
import com.brewku.app.data.model.CoffeeType
import com.brewku.app.data.model.Recipe

object RecipeRepository {

    val allRecipes: List<Recipe> = listOf(
        // 1. V60 Klasik
        Recipe(
            id = "v60_classic",
            name = "V60 Klasik Rumahan",
            method = BrewMethod.V60,
            coffeeType = CoffeeType.ARABICA,
            defaultCoffeeGrams = 15f,
            defaultRatio = 15f, // 1:15 = 225ml
            grindSize = "Medium-Fine (mirip garam meja)",
            waterTemp = "90°C - 92°C (diamkan 1 mnt setelah mendidih)",
            isMinimalToolFriendly = false,
            tagline = "Hasil bersih, aroma semerbak, rasa manis buah alami",
            description = "Metode pour over paling populer di dunia. Aliran air bertahap menghasilkan ekstraksi yang stabil dan manis.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Basahi Kertas Saring & Bilas",
                    instruction = "Bilas filter paper dengan air panas untuk membuang bau kertas, lalu buang air bilasan di server.",
                    targetWaterMl = 0,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Blooming (Pelepasan Gas CO2)",
                    instruction = "Tuang air 45 ml secara memutar pelan. Diamkan kopi memuai dan melepaskan aroma terbaiknya.",
                    targetWaterMl = 45,
                    durationSeconds = 45
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Tuangan Pertama (Rasa Pokok)",
                    instruction = "Tuang air perlahan melingkar dari tengah ke luar hingga total air mencapai 135 ml.",
                    targetWaterMl = 135,
                    durationSeconds = 45
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tuangan Kedua & Tiriskan",
                    instruction = "Tuang sisa air hingga mencapai 225 ml. Goyangkan dripper perlahan sekali, tunggu air tiris sempurna.",
                    targetWaterMl = 225,
                    durationSeconds = 60
                )
            )
        ),

        // 2. Kopi Tubruk Tradisional (Alat Minimal)
        Recipe(
            id = "tubruk_tradisional",
            name = "Tubruk Mantap Anti-Ampas",
            method = BrewMethod.TUBRUK,
            coffeeType = CoffeeType.ROBUSTA,
            defaultCoffeeGrams = 14f,
            defaultRatio = 14f, // 1:14 = 196 ~ 200ml
            grindSize = "Fine / Bubuk Pasar Halus",
            waterTemp = "88°C - 90°C (tidak langsung dari mendidih)",
            isMinimalToolFriendly = true,
            tagline = "Cukup cangkir dan sendok, rasa pekat tanpa ampas mengambang",
            description = "Resep seduh rakyat warisan Indonesia. Dengan trik waktu dan adukan yang tepat, ampas akan tenggelam ke dasar cangkir.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Masukkan Kopi ke Cangkir",
                    instruction = "Masukkan 1 sendok makan munjung kopi bubuk (~14 gram) ke dalam cangkir favoritmu.",
                    targetWaterMl = 0,
                    durationSeconds = 20
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Tuang Air Panas Setengah Cangkir",
                    instruction = "Tuang air panas sekitar 80 ml, diamkan 30 detik agar bubuk kopi terbasahi merata.",
                    targetWaterMl = 80,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Isi Penuh & Aduk 5 Kali",
                    instruction = "Tuang air hingga penuh (~200 ml). Aduk perlahan sebanyak 4-5 kali putaran saja.",
                    targetWaterMl = 200,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tunggu Ampas Tenggelam (Crust Break)",
                    instruction = "Diamkan selama 3 menit. Ampas kopi akan otomatis turun ke dasar. Jika ada buih di atas, sisihkan dengan sendok.",
                    targetWaterMl = 200,
                    durationSeconds = 180
                )
            )
        ),

        // 3. French Press Sederhana
        Recipe(
            id = "french_press_rich",
            name = "French Press Creamy Body",
            method = BrewMethod.FRENCH_PRESS,
            coffeeType = CoffeeType.BLEND,
            defaultCoffeeGrams = 18f,
            defaultRatio = 14f, // 1:14 = 252ml
            grindSize = "Coarse (Kasar mirip garam laut / pasir pantai)",
            waterTemp = "92°C - 94°C",
            isMinimalToolFriendly = false,
            tagline = "Rasa tebal, oily lezat, dan ramah lambung",
            description = "Metode rendam penuh yang mengekstraksi minyak alami kopi. Menghasilkan rasa gurih lembut tanpa perlu kertas filter.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Tuang Kopi & Seluruh Air",
                    instruction = "Masukkan bubuk kopi kasar ke wadah French Press. Tuang langsung 250 ml air panas ke atasnya.",
                    targetWaterMl = 250,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Rendam Penuh (Steeping)",
                    instruction = "Pasang plunger di atasnya (jangan ditekan). Biarkan kopi terekstraksi perlahan selama 4 menit.",
                    targetWaterMl = 250,
                    durationSeconds = 240
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Tekan Plunger Pelan-Pelan",
                    instruction = "Tekan batang plunger ke bawah perlahan dan stabil. Jangan dipaksa sampai dasar. Siap tuang ke cangkir!",
                    targetWaterMl = 250,
                    durationSeconds = 30
                )
            )
        ),

        // 4. Cold Brew Botol Kulkas (Alat Minimal)
        Recipe(
            id = "cold_brew_easy",
            name = "Cold Brew Botol Kulkas",
            method = BrewMethod.COLD_BREW,
            coffeeType = CoffeeType.ARABICA,
            defaultCoffeeGrams = 30f,
            defaultRatio = 10f, // 1:10 = 300ml konsentrat
            grindSize = "Coarse (Kasar)",
            waterTemp = "Air Matang Suhu Ruangan / Air Dingin",
            isMinimalToolFriendly = true,
            tagline = "Manis alami, asam sangat rendah, tahan 1 minggu di kulkas",
            description = "Sangat praktis untuk dinikmati dengan es batu atau susu. Cukup botol kaca biasa dan saringan teh.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Campur Kopi & Air di Botol",
                    instruction = "Masukkan 30g bubuk kopi ke dalam toples/botol kaca, tambahkan 300ml air suhu ruangan. Aduk hingga rata.",
                    targetWaterMl = 300,
                    durationSeconds = 60
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Tutup Rapat & Simpan di Kulkas",
                    instruction = "Tutup wadah rapat-rapat, lalu masukkan ke dalam kulkas (chiller). Diamkan 12 hingga 18 jam.",
                    targetWaterMl = 300,
                    durationSeconds = 120
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Saring Konsentrat Kopi",
                    instruction = "Saring cairan kopi menggunakan saringan teh atau kain bersih. Sajikan dingin dengan es batu!",
                    targetWaterMl = 300,
                    durationSeconds = 60
                )
            )
        ),

        // 5. Vietnam Drip Kopi Susu Mantap
        Recipe(
            id = "vietnam_drip_kental",
            name = "Vietnam Drip Kopi Susu",
            method = BrewMethod.VIETNAM_DRIP,
            coffeeType = CoffeeType.ROBUSTA,
            defaultCoffeeGrams = 16f,
            defaultRatio = 8f, // Kental pekat untuk campur susu
            grindSize = "Medium (sedikit lebih kasar dari espresso)",
            waterTemp = "90°C - 94°C",
            isMinimalToolFriendly = false,
            tagline = "Perpaduan kental Robusta dan manis legit susu kental manis",
            description = "Gaya seduh ala Saigon yang sangat disukai pecinta kopi pekat dan manis di warung kopi.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Tuang Susu Kental Manis",
                    instruction = "Tuang 2 sendok makan susu kental manis (sekitar 25-30g) ke dasar gelas kaca.",
                    targetWaterMl = 0,
                    durationSeconds = 20
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Ratakan Kopi & Pasang Tamper",
                    instruction = "Taruh bubuk kopi di filter Phin, putar saringan tamper secukupnya (jangan terlalu kencang).",
                    targetWaterMl = 0,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Blooming 20 ml Air Panas",
                    instruction = "Tuang 20 ml air panas ke filter, biarkan bubuk mengembang selama 30 detik.",
                    targetWaterMl = 20,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tuang Air Penuh & Tunggu Drip",
                    instruction = "Tuang air hingga penuh (~110 ml), tutup filter dan nikmati tetesan kopi perlahan selama 4-5 menit.",
                    targetWaterMl = 130,
                    durationSeconds = 270
                )
            )
        ),

        // 6. Moka Pot Kopi Susu Kafe
        Recipe(
            id = "moka_pot_rich",
            name = "Moka Pot ala Espresso",
            method = BrewMethod.MOKA_POT,
            coffeeType = CoffeeType.ROBUSTA,
            defaultCoffeeGrams = 16f,
            defaultRatio = 6f, // 1:6 rasio espresso-like
            grindSize = "Fine (Halus, tapi tidak sehalus tepung)",
            waterTemp = "Air Panas Awal di Boiler",
            isMinimalToolFriendly = false,
            tagline = "Ekstraksi tebal berbusa krema di atas kompor dapur",
            description = "Menghasilkan base kopi espresso yang kuat untuk membuat Es Kopi Susu Gula Aren atau Americano.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Isi Boiler Bawah dengan Air Panas",
                    instruction = "Isi tangki bawah dengan air mendidih tepat di bawah katup pengaman (*safety valve*).",
                    targetWaterMl = 100,
                    durationSeconds = 40
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Ratakan Bubuk Kopi di Keranjang",
                    instruction = "Isi corong filter kopi hingga rata. Ratakan dengan jari tanpa ditekan padat.",
                    targetWaterMl = 100,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Nyalakan Api Kecil",
                    instruction = "Tutup rapat bagian atas (gunakan lap karena bawah panas), taruh di atas kompor dengan api kecil.",
                    targetWaterMl = 100,
                    durationSeconds = 120
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Aliran Kopi Emas (Matikan Saat Berbuih)",
                    instruction = "Kopi cokelat keemasan akan mengalir ke atas. Begitu mulai mengeluarkan suara mendesis/buih kuning, segera angkat!",
                    targetWaterMl = 100,
                    durationSeconds = 45
                )
            )
        )
    )

    fun getRecipeById(id: String): Recipe? {
        return allRecipes.find { it.id == id }
    }

    fun getRecipesByMethod(method: BrewMethod): List<Recipe> {
        return allRecipes.filter { it.method == method }
    }
}
