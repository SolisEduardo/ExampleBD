package com.example.examplebd.Model

import kotlin.random.Random

data class QuestionViewModel(
    var id: Int = getAutoId(),
    var question1: String = "",
    var question2: String = "",
    var question3: String = "",
    var question4: String = "",
    var question5: String = "",
    var date: String = ""
){
    companion object{
        fun getAutoId():Int
        {
            val random = Random
            return random.nextInt(100)
        }
    }

}
