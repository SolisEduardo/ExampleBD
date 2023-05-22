package com.example.examplebd.IU.QuestionOne

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.examplebd.Data.SQLiteHelper
import com.example.examplebd.MainActivity
import com.example.examplebd.Model.QuestionViewModel
import com.example.examplebd.R
import com.example.examplebd.Utils.getDateQuestions
import com.example.examplebd.databinding.ActivityQuestionOneBinding
import com.example.examplebd.databinding.DialogConfirmationBinding

class QuestionOne : AppCompatActivity() {
    private var name: String?=""
    private var question1 : String=""
    private var question2 : String?=""
    private var question3 : String?=""
    private var question4 : String?=""
    private var question5 : String?=""

    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var number3 : EditText
    private lateinit var number4 : EditText
    private lateinit var number5 : EditText
    private lateinit var btnFinalizar : TextView
    private lateinit var sqLiteHelper: SQLiteHelper

    var localDate = getDateQuestions()
    @RequiresApi(Build.VERSION_CODES.O)
    private var date : String = localDate.localDate()
    private val TAG : String = QuestionOne::class.java.simpleName
    private lateinit var binding: ActivityQuestionOneBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        sqLiteHelper = SQLiteHelper(this)
        binding.btnQuestionSectionOne.setOnClickListener {
            if (!validations()) dialogConfirmation()

        }


    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun validations(): Boolean
    {
        val num1 = number1.text.toString()
        val num2 = number2.text.toString()
        val num3 = number3.text.toString()
        val num4 = number4.text.toString()
        val num5 = number5.text.toString()
        if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty() || num4.isEmpty() || num5.isEmpty())
        {
            Log.e(TAG,getString(R.string.is_empty))
            Toast.makeText(this,R.string.is_empty, Toast.LENGTH_SHORT).show()
            return true
        }
        else{
            //addQuestions()
            return false
        }


    }

    private fun initView()
    {
        number1 = binding.questionSection1Number1
        number2 = binding.questionSection1Number2
        number3 = binding.questionSection1Number3
        number4 = binding.questionSection1Number4
        number5 = binding.questionSection1Number5
        btnFinalizar = binding.btnQuestionSectionOne

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun dialogConfirmation()
    {
        getResuls()
        val dialogBinding = DialogConfirmationBinding.inflate(layoutInflater)
        val builder = android.app.AlertDialog.Builder(this@QuestionOne)
        builder.setView(dialogBinding.root)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialogBinding.btnConfirmationDialog.setOnClickListener{

            startActivity(
                Intent(this@QuestionOne, MainActivity::class.java)
                    .putExtra("questionSection1One",question1))
            val preferences = it.getContext().getSharedPreferences("dateSectionOne", Context.MODE_PRIVATE)
            val editor= preferences.edit()
            editor.putString("dateOne",date)
            editor.putString("questionSection1One",question1)
            editor.putString("questionSection2One",question2)
            editor.putString("questionSection3One",question3)
            editor.putString("questionSection4One",question4)
            editor.putString("questionSection5One",question5)
            editor.apply()
            Log.i(TAG,"$question1, $question2, $question3, $question4, $question5, $date")
            //Toast.makeText(this,"$question1, $question2, $question3, $question4, $question5",Toast.LENGTH_SHORT).show()
        }
        dialogBinding.imgClose.setOnClickListener {
            dialog.cancel()
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getResuls()
    {
        addQuestions()

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun addQuestions()
    {
        val num1 = number1.text.toString()
        val num2 = number2.text.toString()
        val num3 = number3.text.toString()
        val num4 = number4.text.toString()
        val num5 = number5.text.toString()
        val date1 : String = localDate.localDate()
        question1 = num1
        question2 = num2
        question3 = num3
        question4 = num4
        question5 = num5
        date = date1
        val question = QuestionViewModel(question1 = num1, question2 = num2,question3= num3,question4= num4, question5 = num5, date = date1)
        val status = sqLiteHelper.insertQuestionSection1(question)
        Log.i(TAG,"status $status")
        if (status > -1)
        {
            Toast.makeText(this,getString(R.string.question_add), Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this,getString(R.string.question_not_save), Toast.LENGTH_SHORT).show()
        }
    }
}