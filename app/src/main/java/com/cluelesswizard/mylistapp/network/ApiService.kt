package com.cluelesswizard.mylistapp.network

import com.cluelesswizard.mylistapp.model.ResponseModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val URL = "https://jsonplaceholder.typicode.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(URL)
    .build()

interface API {
    @GET("photos")
    suspend fun getProperties(): List<ResponseModel>
}

object ApiService {
    val retrofitService : API by lazy {
        retrofit.create(API::class.java)
    }
}