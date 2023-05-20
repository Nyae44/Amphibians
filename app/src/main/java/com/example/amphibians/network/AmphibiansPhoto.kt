package com.example.amphibians.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibiansPhoto (
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgSrc: String

        )