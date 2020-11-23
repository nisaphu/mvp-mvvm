package com.example.businesscard.mvvm.model

import com.squareup.moshi.Json

data class Images(
    @field:Json(name = "fixed_height_small_still") val fixedHeightSmallStill: FixedHeightSmallStill
)