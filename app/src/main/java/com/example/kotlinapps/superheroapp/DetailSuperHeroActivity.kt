package com.example.kotlinapps.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivityDetailSuperHeroBinding
import com.example.kotlinapps.superheroapp.data.SuperHeroDetailResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailSuperHeroBinding
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val id:String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroInformation(id)
    
    }

    private fun getSuperHeroInformation(id: String) {
        // Hace la petición a internet (hilo segundario)
        CoroutineScope(Dispatchers.IO).launch {
            val superheroDetail =
                getRetrofit().create(ApiService::class.java).getSuperheroDetails(id) // Solamente hacemos una llamada

            if(superheroDetail.body() !=null){
                runOnUiThread { createUI(superheroDetail.body()!!) }

            }
        }
    }
    private fun createUI(superhero: SuperHeroDetailResponse){
        Picasso.get().load(superhero.image.url).into(binding.ivSuperHero)
    }

    private fun getRetrofit(): Retrofit {
        return  Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create()) // Para Transformar
            .build()
    }
}