package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Recommendation

object LocalDataProvider {
    val default = placeRecommendation()[0]

    fun placeRecommendation() : List<Recommendation> {
        return listOf(
            Recommendation(
                name = "Tjong A Fie Mansion",
                location = "Medan",
                image = R.drawable.tjong_a_fie_mansion,
                description = "Tjong's long-time residence is located at Kesawan Street, Medan. The mansion is an architectural mix of Malay, European, and Tionghoa styles and contains forty rooms, each lined with hand-painted floor tiles from Italy and the walls depicting life in China with great detail.\n" +
                        "The Tjong A Fie Mansion consists of two floors with each floor having its own designation. The first floor consists of several important rooms, including the right side of the house reserved for ethnically Chinese guests only, while the left side of the house has a room reserved for the Sultan of Deli and his family or guests. The middle room on the ground floor is a reception room for guests—the room has a door ten meters tall and has a Chinese-style wooden door handle. On the back of the ground floor, there are spaces for ancestral worship, private rooms, and Tjong's family room. The top floor of the building is used as a ball room or meeting room; there is also an altar facing the meeting room used as a means of worship by Tjong and his family.\n"
            ),
            Recommendation(
                name = "Istana Maimun",
                location = "Medan",
                image = R.drawable.istana_maimun,
                description = "is an istana (royal palace) of the Sultanate of Deli and a well-known landmark in Medan, the capital city of Northern Sumatra, Indonesia. Today, it serves as a museum. The name is the Arabic word for \"blessing\".Built by Sultan Ma'mun Al Rashid Perkasa Alamyah in years 1887–1891, the palace was designed by the Dutch architect Theodoor van Erp and covers 2,772 m2 with a total of 30 rooms. The palace has become a popular tourist destination in the city, not solely because of its historical heritage status, but also because of its unique interior design of the palace, combining elements of Malay cultural heritage, Islamic and Indian architecture, with Spanish and Italian furniture and fittings."
            ),
            Recommendation(
                name = "Masjid Raya Medan",
                location = "Medan",
                image = R.drawable.mesjid_raya_medan,
                description = "Grand Mosque of Medan or Masjid Raya Al-Mashun is a mosque located in Medan, Indonesia. The mosque was built in the year 1906 and completed in 1909. In beginning of its establishment, the mosque was a part of the Maimun palace complex. Its architectural style combines Middle Eastern, Indian and Spanish elements. The mosque has an octagonal shape and has wings to the south, east, north and west."
            ),
            Recommendation(
                name = "Museum Rahmat",
                location = "Medan",
                image = R.drawable.rahmat_museum,
                description = "Rahmat International Wildlife Museum & Gallery is a natural history museum in Medan, Indonesia. The museum displays collections of various wildlife from the smallest to the largest according to the habitat.After the development was completed in October 2007, the Museum & Gallery has an area of 2970 m² building.\n" +
                        "\n" +
                        "Its founder is a fan of sport hunting and the conservation of nature. Through the museum, he invites visitor to better understand the diversity of wildlife that exist in the world and their importance."
            ),
            Recommendation(
                name = "London Sumatera",
                location = "Medan",
                image = R.drawable.london_sumatera,
                description = "PT Perusahaan Perkebunan London Sumatra Indonesia Tbk atau biasa disingkat menjadi Lonsum, adalah sebuah perusahaan agroindustri yang berkantor pusat di Jakarta, Indonesia. Hingga tanggal 31 Desember 2020, Lonsum mengelola kebun kelapa sawit, karet, kakao, dan teh dengan total luas 116.053 hektar yang tersebar di Sumatera Utara, Sumatera Selatan, Kalimantan Timur, Sulawesi, dan Jawa. Untuk mendukung kegiatan bisnisnya, perusahaan ini pun memiliki kantor wilayah di Medan, Palembang, Makassar, dan Samarinda."
            ),
            Recommendation(
                name = "Masjid Al-Osmani",
                location = "Medan",
                image = R.drawable.mesjid_al_osmani,
                description = "Al-Osmani Mosque is a mosque in Medan, North Sumatra, Indonesia. The mosque is also known as Labuhan mosque because of its location in the district of Medan Labuhan. The mosque is located on the K.L. Yos Sudarso road, subdistrict of Pekan Labuhan, about 20 kilometers north of the city of Medan. In front of this mosque there are a school, named YASPI School (Islamic Education Foundation) and not far from the mosque there are a Chinese temple named Pekong Lima and in front of the temple there is a path that leads to Labuhan market. The mosque is the oldest in the city of Medan."
            )
        )
    }
}