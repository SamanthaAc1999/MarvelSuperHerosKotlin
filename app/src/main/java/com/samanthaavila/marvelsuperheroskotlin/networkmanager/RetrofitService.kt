package com.samanthaavila.marvelsuperheroskotlin.networkmanager

import com.samanthaavila.marvelsuperheroskotlin.main.model.MarvelResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/characters")
    suspend fun getMarvels(@Query("ts") ts: String,
                           @Query("apikey") apikey: String,
                           @Query("hash") hash: String): MarvelResponse
//    suspend fun getMarvels(@Query("apikey") apiKey: String): MarvelResponse
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)

    }
//    https://gateway.marvel.com/v1/public/characters?ts=1&apikey=c51ad311d4800ee7e959e4cb34f929b8&hash=0a96e3bd6d9eb58e31998051c1c686ca
}