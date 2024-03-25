package com.example.kotlinapps.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySettingsBinding

//Creamos una función de extension
val Context.dataStore : DataStore<Preferences>  by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    private lateinit var  binding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        

    }
}