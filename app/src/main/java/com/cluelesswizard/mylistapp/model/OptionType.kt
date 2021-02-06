package com.cluelesswizard.mylistapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class OptionType (
    val id: String,
    val title: String,
    val type: String,
    @Transient val values: Map<String,String>? = null,
    @Json(name = "additional_price") val additionalPrice: String?,
    @Transient @Json(name = "additional_price_breakdown") val additionalPriceBreakdown: Map<String,String>? = null
    ):Parcelable