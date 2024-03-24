package com.example.kotlinapps.superheroapp

import com.example.kotlinapps.superheroapp.data.SuperHeroDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/AQUI FALTA EL TOKEN/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>


}