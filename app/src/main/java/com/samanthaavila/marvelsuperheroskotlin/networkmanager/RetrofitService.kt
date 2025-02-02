package com.samanthaavila.marvelsuperheroskotlin.networkmanager

import com.samanthaavila.marvelsuperheroskotlin.model.MarvelResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/characters")
    suspend fun getMarvels(@Query("apikey") apiKey: String): MarvelResponse
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("http://gateway.marvel.com")
            //.addConverterFactory(GsonConvertFactory.create())
            .build()
            .create(RetrofitService::class.java)

    }

}