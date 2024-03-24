package com.example.kotlinapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.kotlinapps.firstapp.FirstAppActivity
import com.example.kotlinapps.imccalculator.ImcCalculatorActivity
import com.example.kotlinapps.superheroapp.SuperHeroListActivity
import com.example.kotlinapps.todoapp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludarApp = findViewById<AppCompatButton>(R.id.btnSaludarApp)
        val btnIMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnToDoApp = findViewById<AppCompatButton>(R.id.btnToDoApp)
        val btnSuperHero = findViewById<AppCompatButton>(R.id.btnSuperHeroApp)

        btnSaludarApp.setOnClickListener { navigateToSaludarApp() }
        btnIMCApp.setOnClickListener { navigateToImcApp() }
        btnToDoApp.setOnClickListener { navigateToToDoApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this,SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToToDoApp() {
        val intent = Intent(this,ToDoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent ( this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludarApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }


}