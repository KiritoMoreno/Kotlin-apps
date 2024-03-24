package com.example.kotlinapps.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySuperHeroListBinding
import com.example.kotlinapps.superheroapp.DetailSuperHeroActivity.Companion.EXTRA_ID
import com.example.kotlinapps.superheroapp.data.SuperHeroAdapter
import com.example.kotlinapps.superheroapp.data.SuperHeroDataResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter : SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Está función se va a llamar cuando usemosel buscador
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
        adapter = SuperHeroAdapter{navigateToDetail(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager= LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter

    }

    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful){
                Log.i("Moreno", "Funciona")
                val response : SuperHeroDataResponse? = myResponse.body()
                if(response !=null){
                    Log.i("Moreno", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superheroes) // llamamos este metodo del adapter (updateList)
                        binding.progressBar.isVisible = false } // Corre en el hilo principal
                }
            }else{
                Log.i("Moreno", "No Funciona =(")
            }
        }
    }

    // Nos va devolver una instancia de Retrofit
    private fun getRetrofit(): Retrofit {
        return  Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create()) // Para Transformar
            .build()
    }
    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperHeroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

}