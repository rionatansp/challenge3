package binar.academy.challenge3

object Menu {
    val menus: List<Any>
        get() = mutableListOf(
            "Minuman",
            MenuItem("Milkshake Pink", 12000, 10, R.drawable.milkshake_pink, "Nikmati kelezatan segar dengan Milkshake Strawberry kami. Dibuat dengan campuran lembut susu segar dan buah strawberry manis, setiap tegukan adalah ledakan rasa yang menggugah selera. Tekstur krimi dan aroma alami buah akan memanjakan lidah Anda. ",1),
            MenuItem("Kopi Item", 15000, 10, R.drawable.kopi, "Dari biji pilihan hingga proses penyeduhan yang teliti, setiap gelas kopi adalah karya seni yang memukau lidah Anda. Rasakan kekayaan cita rasa dalam setiap tegukan, dari espresso yang kuat hingga latte lembut.",  1),
            "Makanan",
            MenuItem("Ayam Oven", 55000, 10, R.drawable.ayam_oven, "Nikmati Kesempurnaan dalam Setiap Gigitan! Ayam Panggang Kami: Kulit yang Renyah, Daging yang Lezat, dan Rempah-Rempah yang Menggoda Selera. Pengalaman Sensasi Rasa yang Membuat Lidah Anda Bergoyang. Hidangan Istimewa ini Akan Membuat Anda Tersenyum Puas. Segera Sajikan untuk Kenikmatan Tiada Tanding!",1),
            MenuItem("Spagheti", 25000, 10, R.drawable.spagheti, "Pesta Sensasi di Mulut Anda! Spaghetti Al Dente yang Disajikan dalam Saus Tomat Segar yang Menggugah Selera, Disempurnakan dengan Taburan Keju Parmesan yang Gurih. Pengalaman Rasa Italia yang Autentik dalam Setiap Gigitan. Rasakan Kenikmatan Sejati dari Tradisi Kuliner Italia!",  1),
            MenuItem("Burger", 20000, 10, R.drawable.burger, "Melejitkan Kenikmatan dalam Setiap Gigitan! Burger Istimewa Kami: Daging Panggang Sempurna, Sayuran Segar yang Meledak Rasa, dan Saus Khas yang Menggoda Selera. Pengalaman Rasa yang Menggetarkan Lidah Anda. Sajikan dengan Cinta, Nikmati dengan Gembira!" ,  1),
            MenuItem("French Fries", 15000, 10, R.drawable.french_fries, "Gorengan Emas yang Menggoda Selera! French Fries Khas Kami: Potongan Kentang yang Garing Luar Biasa, Dengan Tekstur Empuk di Dalam. Disajikan dengan Saus Pilihan, Membuat Setiap Gigitan Sebuah Sensasi. Nikmati Kenikmatan Sederhana yang Tak Tergantikan!",  1),
            MenuItem("Siomay", 15000, 10, R.drawable.siomay, "Kesenangan dalam Setiap Bungkusan! Siomay Istimewa Kami: Gulungan Tipis Kulit Tahu yang Menggoda, Dipenuhi dengan Isian Gurih dan Ikan Segar. Disajikan dengan Saus Kacang Pedas yang Membuat Lidah Anda Bergoyang. Rasakan Citra Rasa Autentik dari Kelezatan Asia!"),
            MenuItem("Mie Kuah", 15000, 10, R.drawable.mie_kuah, "Kuah Hangat yang Mendalam, Mi Goreng yang Menggoda. Mie Kuah Spesial Kami: Mie Lembut yang Menyerap Aroma Kaldu Kaya Rasa, Dihiasi dengan Sayuran Segar dan Potongan Daging Pilihan. Rasakan Kelezatan Dalam Setiap Sendokannya. Pengalaman Rasa yang Membuat Hatimu Tersenyum!"),
            MenuItem("Dimsum", 15000, 10, R.drawable.dimsum, "Nikmati kelezatan autentik Asia dalam setiap gigitan dengan menu dimsum kami. Dari siomay segar hingga bakpao lembut berisi daging pilihan, setiap hidangan merupakan perpaduan sempurna antara tekstur dan rasa yang memikat. Jelajahi berbagai pilihan, dari har gow klasik hingga rolade ikan kepiting yang menggoda selera. "),
            MenuItem("Sushi", 25000, 10, R.drawable.sushi, "Nikmati kelezatan sushi segar yang dipersiapkan dengan telaten. Setiap gulungan menggabungkan cita rasa alami bahan-bahan terbaik dengan sentuhan kreatif. Dari Nigiri elegan hingga Maki yang inovatif, setiap gigitan adalah pengalaman cita rasa yang memikat.")
        )
}