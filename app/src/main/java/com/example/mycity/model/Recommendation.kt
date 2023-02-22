package com.example.mycity.model

import androidx.annotation.DrawableRes

data class Recommendation(
    val name: String,
    val location: String,
    val description: String,
    @DrawableRes val image: Int
)
