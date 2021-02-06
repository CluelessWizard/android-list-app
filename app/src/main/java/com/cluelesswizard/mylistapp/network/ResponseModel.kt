package com.cluelesswizard.mylistapp.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    var url: String,
    var thumbnailUrl: String
): Parcelable
