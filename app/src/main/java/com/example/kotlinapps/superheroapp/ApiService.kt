package com.example.kotlinapps.superheroapp

import com.example.kotlinapps.superheroapp.data.SuperHeroDataResponse
import com.example.kotlinapps.superheroapp.data.SuperHeroDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/AQUI FALTA EL TOKEN/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>

    @GET("/api/Aqui falta el token/{id}")
    suspend fun getSuperheroDetails(@Path("id") superheroId : String): Response<SuperHeroDetailResponse>

}