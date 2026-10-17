package com.brewku.app.data.repository

import com.brewku.app.data.model.TroubleshootTip

object TroubleshootRepository {

    val allTips: List<TroubleshootTip> = listOf(
        TroubleshootTip(
            id = "acidic_sour",
            issue = "Terlalu Asam / Sepet (Kecut)",
            condition = "Under-extracted (Kurang Terekstraksi)",
            iconEmoji = "🍋",
            symptoms = "Rasa asam tajam menusuk lidah depan, tidak ada manisnya, dan setelah diminum rasa kopi cepat hilang begitu saja.",
            causes = listOf(
                "Suhu air seduhan kurang panas.",
                "Ukuran gilingan kopi terlalu kasar.",
                "Waktu seduh terlalu cepat (air mengalir kelewat deras).",
                "Rasio air terlalu sedikit."
            ),
            solutions = listOf(
                "Naikkan suhu air 2°C – 3°C (gunakan air yang baru saja mendidih).",
                "Giling 1 - 2 klik lebih halus pada grinder.",
                "Perlambat tuangan air saat menyeduh pour over.",
                "Perpanjang waktu blooming menjadi 45 detik."
            )
        ),
        TroubleshootTip(
            id = "bitter_harsh",
            issue = "Terlalu Pahit / Gosong / Kering",
            condition = "Over-extracted (Kelewat Terekstraksi)",
            iconEmoji = "🪵",
            symptoms = "Rasa pahit pekat yang mengeringkan lidah bagian belakang, ada rasa gosong atau seperti arang/abu.",
            causes = listOf(
                "Suhu air terlalu mendidih dan membakar kopi (terutama biji dark roast/Robusta).",
                "Ukuran gilingan terlalu halus hingga menyumbat filter.",
                "Waktu kontak air dan kopi terlalu lama."
            ),
            solutions = listOf(
                "Turunkan suhu air ke 85°C – 88°C (diamkan 1-2 menit setelah kompor mati).",
                "Giling 1 - 2 klik lebih kasar.",
                "Percepat tuangan air dan jangan aduk terlalu agresif.",
                "Jika kopi sudah terlanjur pahit, tambahkan sedikit air panas (*bypass*) untuk mengencerkannya."
            )
        ),
        TroubleshootTip(
            id = "watery_weak",
            issue = "Kopi Encer / Hambar",
            condition = "Under-dosed (Kurang Takaran)",
            iconEmoji = "💧",
            symptoms = "Kopi berasa seperti air berwarna cokelat, aroma tidak tercium kuat, rasa manis dan gurih tidak muncul.",
            causes = listOf(
                "Rasio kopi terhadap air terlalu sedikit (misal kopi 10g tapi air 250ml).",
                "Kopi sudah terlalu lama disimpan setelah digiling (kehilangan aroma)."
            ),
            solutions = listOf(
                "Tambah takaran bubuk kopi (perkecil rasio, misal dari 1:17 menjadi 1:14 atau 1:15).",
                "Gunakan biji kopi yang baru digiling sebelum menyeduh.",
                "Perlambat aliran air agar kopi sempat terekstraksi optimal."
            )
        ),
        TroubleshootTip(
            id = "sludgy_muddy",
            issue = "Ampas Mengambang / Kasar di Mulut",
            condition = "Fines / Sedimentasi Berlebih",
            iconEmoji = "🌪️",
            symptoms = "Setiap seruputan terasa berpasir atau ada lumpur ampas di dasar cangkir yang mengganggu.",
            causes = listOf(
                "Kualitas gilingan grinder menghasilkan terlalu banyak debu halus (*fines*).",
                "Pada metode Tubruk, air belum sempat mengendapkan ampas tapi sudah diaduk terlalu sering.",
                "Kertas filter bocor atau robek."
            ),
            solutions = listOf(
                "Untuk Tubruk: Aduk 4 putaran saja di awal, lalu diamkan 3 menit tanpa digoyang sama sekali.",
                "Gunakan saringan teh kain atau kertas saring berkualitas.",
                "Pada French Press: Jangan tekan plunger sampai menyentuh dasar wadah kaca."
            )
        )
    )
}
