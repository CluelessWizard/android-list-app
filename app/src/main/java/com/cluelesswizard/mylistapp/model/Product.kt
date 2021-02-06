package com.cluelesswizard.mylistapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product (
    val id: Int,
    val type: String,
    @Json(name = "type_name") val typeName: String,
    val brand: String?,
    val model: String,
    val image: String?,
    @Json(name = "variant_count") val variantCount: Int,
    val currency: String,
    val files: List<FileType>?,
    val options: List<OptionType>?,
    val dimensions: Map<String,String>?,
    @Json(name = "is_discontinued") val isDiscontinued: Boolean,
    @Json(name = "avg_fulfillment_time") val avgFulfillmentTime: Double?,
    val description: String
    ): Parcelable
