package com.brewku.app.data.model

enum class BrewMethod(
    val displayName: String,
    val categoryName: String,
    val estimatedDuration: String,
    val description: String,
    val emoji: String
) {
    V60(
        displayName = "V60",
        categoryName = "Pour over",
        estimatedDuration = "3-4 menit",
        description = "Karakter rasa bersih, aroma jelas, menonjolkan keasaman manis alami.",
        emoji = "☕"
    ),
    FRENCH_PRESS(
        displayName = "French Press",
        categoryName = "Immersion",
        estimatedDuration = "4-5 menit",
        description = "Seduhan rendam penuh, body tebal dan gurih tanpa kertas saring.",
        emoji = "🫖"
    ),
    COLD_BREW(
        displayName = "Cold Brew",
        categoryName = "Seduh dingin",
        estimatedDuration = "12-18 jam",
        description = "Ekstraksi air dingin di kulkas, sangat halus, rendah asam, manis alami.",
        emoji = "🧊"
    ),
    TUBRUK(
        displayName = "Tubruk",
        categoryName = "Cara tradisional",
        estimatedDuration = "4 menit",
        description = "Gaya seduh khas Nusantara. Cukup bubuk kopi, air panas, dan sendok.",
        emoji = "🇮🇩"
    ),
    AEROPRESS(
        displayName = "AeroPress",
        categoryName = "Tekanan udara",
        estimatedDuration = "2-3 menit",
        description = "Fleksibel dan cepat, menghasilkan konsentrat rasa kaya dan bebas ampas.",
        emoji = "🚀"
    ),
    VIETNAM_DRIP(
        displayName = "Vietnam Drip",
        categoryName = "Drip saringan",
        estimatedDuration = "4-6 menit",
        description = "Tetesan lambat kental, sangat nikmat dipadukan dengan kental manis.",
        emoji = "🥛"
    ),
    MOKA_POT(
        displayName = "Moka Pot",
        categoryName = "Tekanan uap kompor",
        estimatedDuration = "3-5 menit",
        description = "Seduhan pekat menyerupai espresso untuk bahan dasar es kopi susu.",
        emoji = "🔥"
    )
}

enum class CoffeeType(
    val title: String,
    val recommendedTemp: String,
    val note: String
) {
    ARABICA(
        title = "Arabika",
        recommendedTemp = "90°C - 93°C",
        note = "Rasa kaya buah & bunga, keasaman manis segar."
    ),
    ROBUSTA(
        title = "Robusta",
        recommendedTemp = "85°C - 88°C",
        note = "Body tebal, pekat, aroma earthy cokelat/kacang."
    ),
    BLEND(
        title = "House Blend",
        recommendedTemp = "88°C - 91°C",
        note = "Campuran seimbang antara body dan aroma."
    )
}

data class BrewStep(
    val stepNumber: Int,
    val title: String,
    val instructionTemplate: String,
    val waterPercentage: Float = 0f, // 0.0f - 1.0f
    val durationSeconds: Int
) {
    fun getTargetWater(totalWaterMl: Int): Int {
        return (totalWaterMl * waterPercentage).toInt()
    }

    fun getFormattedInstruction(coffeeGrams: Float, totalWaterMl: Int): String {
        val targetWater = getTargetWater(totalWaterMl)
        return instructionTemplate
            .replace("{coffeeGrams}", coffeeGrams.toInt().toString())
            .replace("{targetWater}", targetWater.toString())
            .replace("{totalWater}", totalWaterMl.toString())
    }
}

data class Recipe(
    val id: String,
    val name: String,
    val method: BrewMethod,
    val coffeeType: CoffeeType,
    val defaultCoffeeGrams: Float = 15f,
    val defaultRatio: Float = 15f, // misal 1:15 -> 15f
    val grindSize: String,
    val waterTemp: String,
    val isMinimalToolFriendly: Boolean = false,
    val tagline: String,
    val description: String,
    val steps: List<BrewStep>
) {
    fun calculateWater(coffeeGrams: Float): Int {
        return (coffeeGrams * defaultRatio).toInt()
    }
}

data class TroubleshootTip(
    val id: String,
    val issue: String,
    val condition: String,
    val iconEmoji: String,
    val symptoms: String,
    val causes: List<String>,
    val solutions: List<String>
)
