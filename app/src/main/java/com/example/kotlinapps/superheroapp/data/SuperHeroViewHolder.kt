package com.example.kotlinapps.superheroapp.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemSuperheroBinding.bind(view)
    fun bind(superheroItemResponse: SuperheroItemResponse){
        binding.tvSuperheroName.text = superheroItemResponse.name
    }
}