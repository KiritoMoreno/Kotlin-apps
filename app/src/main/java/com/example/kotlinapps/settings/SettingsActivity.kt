package com.example.kotlinapps.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

//Creamos una función de extension
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {
    companion object {
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_BLUETOOTH = "key_bluetooth"
        const val KEY_DARK_MODE = "key_dark_mode"
        const val KEY_VIBRATION = "key_vibration"
    }

    private lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


    }

    private fun initUI() {
        binding.rsVolume.addOnChangeListener { _, value, _
            ->
            Log.i("Moreno", "El valor es $value")
            CoroutineScope(Dispatchers.IO).launch { saveVolume(value.toInt()) }
        }

        binding.switchBluetooth.setOnCheckedChangeListener { _, isChecked ->
            CoroutineScope(
                Dispatchers.IO
            ).launch { saveOptions(KEY_BLUETOOTH, isChecked) }
        }
        binding.switchVibrate.setOnCheckedChangeListener { _, isChecked ->
            CoroutineScope(
                Dispatchers.IO
            ).launch { saveOptions(KEY_VIBRATION, isChecked) }
        }
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            CoroutineScope(
                Dispatchers.IO
            ).launch { saveOptions(KEY_DARK_MODE, isChecked) }
        }
    }

    private suspend fun saveVolume(value: Int) {
        //Coroutines
        dataStore.edit { preferences ->
            preferences[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        // booleano para las opciones de On y Off de los adjustes
        // Usamos un Flow para que comunique ( continua y bidireccional)
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    // Una función que me regrese todos los valores
    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                volume = preferences[intPreferencesKey(VOLUME_LVL)] ?: 50,
                bluetooth = preferences[booleanPreferencesKey(KEY_BLUETOOTH)] ?: true,
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)] ?: false,
                vibration = preferences[booleanPreferencesKey(KEY_VIBRATION)] ?: true

            )
        }

    }
}