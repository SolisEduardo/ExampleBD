package com.example.examplebd.IU.StoredSurveys

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examplebd.MainActivity
import com.example.examplebd.R
import com.example.examplebd.databinding.ActivitySplashBinding
import com.example.examplebd.databinding.ActivityStoredSurveysBinding

class StoredSurveys : AppCompatActivity() {
    private lateinit var binding: ActivityStoredSurveysBinding
    private var dateOne : String=""
    private var dateTwo : String=""
    private var dateThree : String=""
    private lateinit var preferencesOne: SharedPreferences
    private lateinit var preferencesTwo: SharedPreferences
    private lateinit var preferencesThree: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoredSurveysBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesOne = applicationContext.getSharedPreferences("dateSectionOne", Context.MODE_PRIVATE)
        preferencesTwo = applicationContext.getSharedPreferences("dateSectionTwo", Context.MODE_PRIVATE)
        preferencesThree = applicationContext.getSharedPreferences("dateSectionThree", Context.MODE_PRIVATE)
        validations()
        binding.btnVolverMenu.setOnClickListener {
            startActivity(Intent(this@StoredSurveys, MainActivity::class.java)
                .putExtra("name","eduardo"))
        }


       // dateOne = preferencesOne?.getString("dateOne","").toString()
        //Log.d("Stored","$dateOne")
        //binding.datequestion1.text = dateOne
    }
    private fun validations()
    {
        dateOne = preferencesOne.getString("dateOne","").toString()
        dateThree = preferencesThree.getString("dateThree","").toString()
        dateTwo = preferencesTwo.getString("dateTwo","").toString()

        if(dateOne =="") binding.datequestion1.text = getString(R.string.survey_not_completed)
        else binding.datequestion1.text = dateOne

        if (dateTwo == "") binding.datequestion2.text = getString(R.string.survey_not_completed)
        else binding.datequestion2.text = dateTwo

        if(dateThree =="") binding.datequestion3.text = getString(R.string.survey_not_completed)
        else binding.datequestion3.text = dateThree


    }
}