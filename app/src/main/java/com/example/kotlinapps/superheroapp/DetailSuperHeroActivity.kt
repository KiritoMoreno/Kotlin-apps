package com.example.kotlinapps.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivityDetailSuperHeroBinding
import com.example.kotlinapps.superheroapp.data.PowerStatsResponse
import com.example.kotlinapps.superheroapp.data.SuperHeroDetailResponse
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

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
        binding.tvSuperheroName.text = superhero.name
        prepareStats(superhero.powerstats)
        binding.tvSuperheroRealName.text = superhero.biography.fullName
        binding.tvSuperheroRace.text = superhero.appearance.race
        binding.tvPublisher.text = superhero.biography.publisher
        binding.tvSuperheroGender.text = superhero.appearance.gender
    }
    private fun prepareStats(powerstats: PowerStatsResponse){
        //Llamamos el metodo updateHeight para cada atributo
        updateHeight(binding.viewIntelligence, powerstats.intelligence)
        updateHeight(binding.viewStrength, powerstats.strength)
        updateHeight(binding.viewSpeed, powerstats.speed)
        updateHeight(binding.viewDurability,powerstats.durability)
        updateHeight(binding.viewCombat, powerstats.combat)
        updateHeight(binding.viewPower,powerstats.power)

    }
    private fun updateHeight(view: View, stat:String){
        // Este metodo va recibir una view y va actuar sobre esa view  y luego necesitara un entero stat que le llega por parametro
        // Asi no repitimos codigo
        val params = view.layoutParams
        params.height = pxToDp(stat.toFloat())
        view.layoutParams = params
    }
    private fun pxToDp(px:Float):Int{
        // Convertimos pixel to DP
        // resources.displayMetrics -> Va ajustarse sobre el tamaño de la pantalla
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px , resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return  Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create()) // Para Transformar
            .build()
    }
}