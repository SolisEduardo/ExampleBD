package com.example.examplebd.Utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class getDateQuestions {
    @RequiresApi(Build.VERSION_CODES.O)
     fun localDate(): String
    {
        val dateFormat: DateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm aa")
        val date = Date()
        val dateString = dateFormat.format(date)
        Log.d("MainActivity","Current month $dateString")
        return dateString.toString()
    }
}
