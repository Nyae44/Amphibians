package com.example.amphibians.fake

import com.example.amphibians.network.AmphibiansPhoto

object FakeDataSource {
    const val nameOne = "stringOne"
    const val nameTwo = "stringTwo"
    const val typeOne = "typeStringOne"
    const val typeTwo = "typeStringTwo"
    const val descriptionOne = "descriptionStringOne"
    const val descriptionTwo = "descriptionStringTwo"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf(
        AmphibiansPhoto(
            name = nameOne,
            type = typeOne,
            description = descriptionOne,
            imgSrc = imgOne
        ),
        AmphibiansPhoto(
            name = nameTwo,
            type = typeTwo,
            description = descriptionTwo,
            imgSrc = imgTwo
        )
    )
}