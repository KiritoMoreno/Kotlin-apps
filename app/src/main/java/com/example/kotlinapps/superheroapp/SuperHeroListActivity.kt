package com.example.kotlinapps.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

    }
    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Está función se va a llamar cuando usemosel buscador
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?)=false
        })
    }
    private fun searchByName(query:String){

    }
}