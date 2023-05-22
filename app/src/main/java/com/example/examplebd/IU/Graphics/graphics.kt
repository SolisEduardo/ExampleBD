package com.example.examplebd.IU.Graphics

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.example.examplebd.MainActivity
import com.example.examplebd.Model.QuestionViewModel
import com.example.examplebd.R
import com.example.examplebd.Utils.ramdomColor
import com.example.examplebd.databinding.ActivityGraphicsBinding
import kotlin.math.roundToInt

class graphics : AppCompatActivity() {
    private lateinit var binding: ActivityGraphicsBinding
    private var question1SectionOne: String = ""
    private lateinit var sharedPreferencesOne: SharedPreferences
    private var numberOne: Int =0
    private var numberTwo : Int =0
    private var numberThree : Int =0
    private var numberFour: Int =0
    var getColor = ramdomColor()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphicsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val puntos = ArrayList<Bar>()
        sharedPreferencesOne =
            applicationContext.getSharedPreferences("dateSectionOne", Context.MODE_PRIVATE)
        initOne(puntos)
        initTwo(puntos)
        binding.btnVolver.setOnClickListener{
            startActivity(Intent(this@graphics,MainActivity::class.java)
                .putExtra("name","eduardo"))
        }
    }

    private fun initOne(puntos: ArrayList<Bar>) {
        question1SectionOne = sharedPreferencesOne.getString("questionSection1One", "").toString()
        if (question1SectionOne == "")
        {
            Toast.makeText(this,"No hay datos para ver graficas",Toast.LENGTH_SHORT).show()
        }
        else
        {
            val barra = Bar()
            val color = getColor.getColor()
            barra.color = Color.parseColor(color)
            val names = "Respuesta 1"
            val number = ArrayList<QuestionViewModel>()
            barra.name = names
            barra.value = question1SectionOne.toFloat()
            puntos.add(barra)
            val grafica = findViewById<View>(R.id.graficas) as BarGraph
            grafica.bars = puntos
        }

    }

    private fun initTwo(puntos: ArrayList<Bar>) {
        val add = addAnswers()
        val barra = Bar()
        val color = getColor.getColor()
        barra.color = Color.parseColor(color)
        val names = "Respuesta 2..4"
        barra.name = names
        barra.value = add.toFloat()
        puntos.add(barra)
        val grafica = findViewById<View>(R.id.graficas) as BarGraph
        grafica.bars = puntos
    }

    private fun addAnswers(): Int {
        if (sharedPreferencesOne.getString("questionSection2One", "").toString() == "")
        {
            Log.i("GRAFICOS","NO HAY DATOS")
        }
        else
        {
            numberOne =
                Integer.parseInt(sharedPreferencesOne.getString("questionSection2One", "").toString())
            numberTwo =
                Integer.parseInt(sharedPreferencesOne.getString("questionSection3One", "").toString())
            numberThree =
                Integer.parseInt(sharedPreferencesOne.getString("questionSection4One", "").toString())
             numberFour =
                Integer.parseInt(sharedPreferencesOne.getString("questionSection5One", "").toString())


        }
        return numberOne + numberTwo + numberThree + numberFour

    }
}

