package com.imnstudios.enefte.ui.screens.onboarding

import com.imnstudios.enefte.R

object Data {

    data class OnBoardingData(
        val text: String,
        val image: Int
    )

    val OnBoardingDataItems = listOf(
        OnBoardingData("Discover largest NFT marketplace", R.drawable.image_3),
        OnBoardingData("Start your own NFT gallery now", R.drawable.image_5),
        OnBoardingData("Discovering the  world of crypto art", R.drawable.image_8)
    )
}