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
                    instructionTemplate = "Bilas filter paper dengan air panas untuk membuang bau kertas, lalu buang air bilasan di server.",
                    waterPercentage = 0f,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Blooming (Pelepasan Gas CO2)",
                    instructionTemplate = "Tuang air {targetWater} ml secara memutar pelan. Diamkan kopi memuai dan melepaskan aroma terbaiknya.",
                    waterPercentage = 0.20f, // 20% dari total air
                    durationSeconds = 45
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Tuangan Pertama (Rasa Pokok)",
                    instructionTemplate = "Tuang air perlahan melingkar dari tengah ke luar hingga timbangan mencapai {targetWater} ml.",
                    waterPercentage = 0.60f, // 60% dari total air
                    durationSeconds = 45
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tuangan Kedua & Tiriskan",
                    instructionTemplate = "Tuang sisa air hingga mencapai total {totalWater} ml. Goyangkan dripper perlahan sekali, tunggu air tiris sempurna.",
                    waterPercentage = 1.0f, // 100% total air
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
            defaultRatio = 15f, // 1:15 = 210ml
            grindSize = "Fine / Bubuk Pasar Halus",
            waterTemp = "88°C - 90°C (tidak langsung dari mendidih)",
            isMinimalToolFriendly = true,
            tagline = "Cukup cangkir dan sendok, rasa pekat tanpa ampas mengambang",
            description = "Resep seduh rakyat warisan Indonesia. Dengan trik waktu dan adukan yang tepat, ampas akan tenggelam ke dasar cangkir.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Masukkan Kopi ke Cangkir",
                    instructionTemplate = "Masukkan {coffeeGrams} gram bubuk kopi ke dalam cangkir favoritmu.",
                    waterPercentage = 0f,
                    durationSeconds = 20
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Tuang Air Panas Setengah Cangkir",
                    instructionTemplate = "Tuang air panas sekitar {targetWater} ml, diamkan 30 detik agar bubuk kopi terbasahi merata.",
                    waterPercentage = 0.40f, // 40% air
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Isi Penuh & Aduk 5 Kali",
                    instructionTemplate = "Tuang air hingga penuh ({totalWater} ml). Aduk perlahan sebanyak 4-5 kali putaran saja.",
                    waterPercentage = 1.0f, // 100% air
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tunggu Ampas Tenggelam (Crust Break)",
                    instructionTemplate = "Diamkan selama 3 menit. Ampas kopi akan otomatis turun ke dasar. Jika ada buih di atas, sisihkan dengan sendok.",
                    waterPercentage = 1.0f,
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
            defaultRatio = 15f, // 1:15 = 270ml
            grindSize = "Coarse (Kasar mirip garam laut / pasir pantai)",
            waterTemp = "92°C - 94°C",
            isMinimalToolFriendly = false,
            tagline = "Rasa tebal, oily lezat, dan ramah lambung",
            description = "Metode rendam penuh yang mengekstraksi minyak alami kopi. Menghasilkan rasa gurih lembut tanpa perlu kertas filter.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Tuang Kopi & Seluruh Air",
                    instructionTemplate = "Masukkan {coffeeGrams}g bubuk kopi kasar ke wadah French Press. Tuang langsung seluruh {totalWater} ml air panas ke atasnya.",
                    waterPercentage = 1.0f,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Rendam Penuh (Steeping)",
                    instructionTemplate = "Pasang plunger di atasnya (jangan ditekan). Biarkan kopi terekstraksi perlahan selama 4 menit.",
                    waterPercentage = 1.0f,
                    durationSeconds = 240
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Tekan Plunger Pelan-Pelan",
                    instructionTemplate = "Tekan batang plunger ke bawah perlahan dan stabil. Jangan dipaksa sampai dasar. Siap tuang {totalWater} ml kopi ke cangkir!",
                    waterPercentage = 1.0f,
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
                    instructionTemplate = "Masukkan {coffeeGrams}g bubuk kopi ke toples/botol kaca, tambahkan {totalWater} ml air suhu ruangan. Aduk hingga rata.",
                    waterPercentage = 1.0f,
                    durationSeconds = 60
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Tutup Rapat & Simpan di Kulkas",
                    instructionTemplate = "Tutup wadah rapat-rapat, lalu masukkan ke dalam kulkas (chiller). Diamkan 12 hingga 18 jam.",
                    waterPercentage = 1.0f,
                    durationSeconds = 120
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Saring Konsentrat Kopi",
                    instructionTemplate = "Saring {totalWater} ml konsentrat kopi menggunakan saringan teh atau kain bersih. Sajikan dingin dengan es batu!",
                    waterPercentage = 1.0f,
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
            defaultCoffeeGrams = 15f,
            defaultRatio = 8f, // 1:8 = 120ml
            grindSize = "Medium (sedikit lebih kasar dari espresso)",
            waterTemp = "90°C - 94°C",
            isMinimalToolFriendly = false,
            tagline = "Perpaduan kental Robusta dan manis legit susu kental manis",
            description = "Gaya seduh ala Saigon yang sangat disukai pecinta kopi pekat dan manis di warung kopi.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Tuang Susu Kental Manis",
                    instructionTemplate = "Tuang 2 sendok makan susu kental manis (sekitar 25-30g) ke dasar gelas kaca.",
                    waterPercentage = 0f,
                    durationSeconds = 20
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Ratakan Kopi & Pasang Tamper",
                    instructionTemplate = "Taruh {coffeeGrams}g bubuk kopi di filter Phin, putar saringan tamper secukupnya (jangan terlalu kencang).",
                    waterPercentage = 0f,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Blooming 20% Air Panas",
                    instructionTemplate = "Tuang {targetWater} ml air panas ke filter, biarkan bubuk mengembang selama 30 detik.",
                    waterPercentage = 0.20f,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Tuang Air Penuh & Tunggu Drip",
                    instructionTemplate = "Tuang air hingga penuh ({totalWater} ml), tutup filter dan nikmati tetesan kopi perlahan selama 4-5 menit.",
                    waterPercentage = 1.0f,
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
            defaultRatio = 6f, // 1:6 = 96 ~ 100ml
            grindSize = "Fine (Halus, tapi tidak sehalus tepung)",
            waterTemp = "Air Panas Awal di Boiler",
            isMinimalToolFriendly = false,
            tagline = "Ekstraksi tebal berbusa krema di atas kompor dapur",
            description = "Menghasilkan base kopi espresso yang kuat untuk membuat Es Kopi Susu Gula Aren atau Americano.",
            steps = listOf(
                BrewStep(
                    stepNumber = 1,
                    title = "Isi Boiler Bawah dengan Air Panas",
                    instructionTemplate = "Isi tangki bawah dengan {totalWater} ml air mendidih tepat di bawah katup pengaman (*safety valve*).",
                    waterPercentage = 1.0f,
                    durationSeconds = 40
                ),
                BrewStep(
                    stepNumber = 2,
                    title = "Ratakan Bubuk Kopi di Keranjang",
                    instructionTemplate = "Isi corong filter kopi dengan {coffeeGrams}g bubuk kopi hingga rata tanpa ditekan padat.",
                    waterPercentage = 1.0f,
                    durationSeconds = 30
                ),
                BrewStep(
                    stepNumber = 3,
                    title = "Nyalakan Api Kecil",
                    instructionTemplate = "Tutup rapat bagian atas (gunakan lap karena bawah panas), taruh di atas kompor dengan api kecil.",
                    waterPercentage = 1.0f,
                    durationSeconds = 120
                ),
                BrewStep(
                    stepNumber = 4,
                    title = "Aliran Kopi Emas (Matikan Saat Berbuih)",
                    instructionTemplate = "Kopi cokelat keemasan akan mengalir ke atas ({totalWater} ml). Begitu mulai mendesis, segera angkat!",
                    waterPercentage = 1.0f,
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
