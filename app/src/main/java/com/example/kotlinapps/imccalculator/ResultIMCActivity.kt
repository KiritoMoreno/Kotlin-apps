package com.example.kotlinapps.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.kotlinapps.R
import com.example.kotlinapps.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var tvresult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val result:Double = intent.extras?.getDouble(IMC_KEY)?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }
    private fun initComponents(){
        tvIMC = findViewById(R.id.tvIMC)
        tvresult= findViewById(R.id.tvResult)
        tvDescription= findViewById(R.id.tvDescription)
        btnReCalculate= findViewById(R.id.btnReCalculate)

    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed() // Volver atras
        }
    }

    private fun initUI(result: Double) {
        tvIMC.text= result.toString()
        when(result){
            in 0.00 .. 18.50 ->{ // Bajo peso
                tvresult.text=getString(R.string.title_bajo_peso)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text=getString(R.string.descripcion_bajo_peso)
            }
            in 18.51 .. 24.99 ->{ // Peso normal
                tvresult.text=getString(R.string.title_peso_normal)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text=getString(R.string.descripcion_peso_normal)
            }
            in 25.00 .. 29.99 ->{ // Sobrepeso
                tvresult.text=getString(R.string.title_sobrepeso)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvDescription.text=getString(R.string.descripcion_sobrepeso)
            }
            in 30.00 .. 99.00 ->{ // Obesidad
                tvresult.text=getString(R.string.title_obesidad)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvDescription.text=getString(R.string.descripcion_obesidad)
            }
            else->{ // Error
                tvIMC.text = getString(R.string.error)
                tvresult.text = getString(R.string.error)
                tvresult.setTextColor(ContextCompat.getColor(this,R.color.peso_obesidad))
                tvDescription.text = getString(R.string.error)
            }
        }
    }


}