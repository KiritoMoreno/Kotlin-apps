package com.example.kotlinapps.superheroapp.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R

//
class SuperHeroAdapter(var superheroList: List<SuperheroItemResponse> = emptyList()): RecyclerView.Adapter<SuperHeroViewHolder>(){

    fun updateList(superheroList: List<SuperheroItemResponse>){
        this.superheroList = superheroList
        notifyDataSetChanged() // Recargate que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent,false))
    }

    override fun onBindViewHolder(viewholder: SuperHeroViewHolder, position: Int) {
        viewholder.bind(superheroList[position])
    }

    override fun getItemCount()= superheroList.size
}