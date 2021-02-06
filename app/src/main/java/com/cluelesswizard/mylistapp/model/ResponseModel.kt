package com.cluelesswizard.mylistapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseModel(
    val code : Int,
    val result: List<Product>,
    @Transient val extra: String? = null
): Parcelable
