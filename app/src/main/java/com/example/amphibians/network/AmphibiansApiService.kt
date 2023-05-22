package com.example.amphibians.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
@OptIn(ExperimentalSerializationApi::class)
private val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory(("application/json").toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface AmphibiansApiService{
    @GET("amphibians")
   suspend fun getAmphibians(): List<AmphibiansPhoto>
}
object AmphibiansApi{
    val retrofitService : AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }
}