package com.example.examplebd

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.examplebd.Adapter.QuestionAdapter
import com.example.examplebd.Data.SQLiteHelper
import com.example.examplebd.IU.Graphics.graphics
import com.example.examplebd.IU.QuestionOne.QuestionOne
import com.example.examplebd.IU.QuestionThree.QuestionThree
import com.example.examplebd.IU.QuestionTwo.QuestionTwo
import com.example.examplebd.IU.StoredSurveys.StoredSurveys
import com.example.examplebd.Model.QuestionViewModel
import com.example.examplebd.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
   /*private lateinit var button : Button
   private lateinit var button1 : Button
   private lateinit var texto : TextView
   private lateinit  var number1 : EditText
   private lateinit var number2 : EditText
    private lateinit  var number3 : EditText
    private lateinit var number4 : EditText
    private lateinit  var number5 : EditText

   private lateinit var sqLiteHelper: SQLiteHelper
   private lateinit var recyclerView : RecyclerView
   private var adapter: QuestionAdapter?=null*/
    private lateinit var binding: ActivityMainBinding
    private lateinit var preferencesBoolean: SharedPreferences
    private var booleanOne: String=""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSectionOne.setOnClickListener {
            startActivity(Intent(this@MainActivity,QuestionOne::class.java)
                .putExtra("name","eduardo")
            )
        }
        binding.buttonSectionTwo.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuestionTwo::class.java)
                .putExtra("name","eduardo"))
        }
        binding.buttonSectionThree.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuestionThree::class.java)
                .putExtra("name","eduardo"))
        }
        binding.btnVerEncuestas.setOnClickListener {
            startActivity(Intent(this@MainActivity, StoredSurveys::class.java)
                .putExtra("name","eduardo"))
        }
        binding.btnVerGraficas.setOnClickListener {
            startActivity(Intent(this@MainActivity,graphics::class.java)
                .putExtra("name","eduardo"))
        }
     /* initView()
       // initRecyclerView()
        sqLiteHelper = SQLiteHelper(this)
        button.setOnClickListener {
            texto.text = localDate()
            addResultQuestion()
            /*val date = localDate()
            val number1 = number1!!.text.toString()
            val number2 = number2!!.text.toString()
            texto!!.text = "$date primero numero es : $number1 segundo numero es: $number2"*/


        }
        button1.setOnClickListener {
            startActivity(Intent(this@MainActivity,QuestionOne::class.java)
                .putExtra("name","eduardo"))
        }
        localDate()*/

    }
  /*  @RequiresApi(Build.VERSION_CODES.O)
    private fun addResultQuestion()
    {
        val date = localDate()
        val number1 = number1.text.toString()
        val number2 = number2.text.toString()
        val number3 = number3.text.toString()
        val number4 = number4.text.toString()
        val number5 = number5.text.toString()
        if (number1.isEmpty() || number2.isEmpty())
        {
            Toast.makeText(this,"Please enter required field",Toast.LENGTH_SHORT).show()
        }
        else
        {
            val question = QuestionViewModel(question1 = number1, question2 = number2,question3= number3,question4= number4, question5 = number5, date = date)
            val status = sqLiteHelper.insertQuestionSection1(question)
            if (status > -1)
            {
                Toast.makeText(this,"Question Add...",Toast.LENGTH_SHORT).show()
                Log.i("Main","$number1, $number2,$number3,$number4,$number5")
                clearEditText()

            }
            else
            {
                Toast.makeText(this,"Question not save...",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getDateQuestions()
    {
        val dateList = sqLiteHelper.getAllQuestionSection2()
        adapter?.addItems(dateList)

    }
    private fun clearEditText()
    {
        number1.setText("")
        number2.setText("")
        number1.requestFocus()
    }
    private fun initView()
    {
        button = findViewById(R.id.button)
        button1 = findViewById(R.id.button1)
        texto = findViewById(R.id.txt1)
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        number3 = findViewById(R.id.number3)
        number4 = findViewById(R.id.number4)
        number5 = findViewById(R.id.number5)


       // recyclerView = findViewById(R.id.recycler_quest)
    }
    /*private fun initRecyclerView()
    {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = QuestionAdapter()
        recyclerView.adapter = adapter
    }*/
    @RequiresApi(Build.VERSION_CODES.O)
    private fun localDate(): String
    {
        val dateFormat: DateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm aa")
        val date = Date()
        val dateString = dateFormat.format(date)
        Log.d("MainActivity","Current month $dateString")
        return dateString.toString()

        //new date
      /*  val dateFormat2: DateFormat = SimpleDateFormat("dd/MM/yyyy hh.mm aa")
        val date1String2 = dateFormat2.format(Date()).toString()
        println("Current date and time in AM/PM: $dateString2")*/
    }*/

}