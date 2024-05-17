package com.example.kotlinapps.superheroapp

import com.example.kotlinapps.superheroapp.data.SuperHeroDataResponse
import com.example.kotlinapps.superheroapp.data.SuperHeroDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/16e28eb2e1885da59486491f5a24132e/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>

    @GET("/api/16e28eb2e1885da59486491f5a24132e/{id}")
    suspend fun getSuperheroDetails(@Path("id") superheroId : String): Response<SuperHeroDetailResponse>

}