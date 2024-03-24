package com.example.kotlinapps.superheroapp.data

import com.google.gson.annotations.SerializedName
import java.net.URL

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage: SuperHeroImageResponse
)
data class SuperHeroImageResponse(@SerializedName("url") val url: String)