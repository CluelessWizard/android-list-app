package com.cluelesswizard.mylistapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class FileType (
    val id: String,
    val type: String,
    val title: String,
    @Json(name = "additional_price") val additionalPrice: String?
    ):Parcelable
