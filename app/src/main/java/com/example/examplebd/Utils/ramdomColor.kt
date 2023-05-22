package com.example.examplebd.Utils

import kotlin.math.roundToInt

class ramdomColor {
     fun getColor(): String
    {
        val letras = arrayOf("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F")
        var color ="#"
        for(i in 0..5)
        {
            color += letras[(Math.random()*15).roundToInt()]
        }
        return color
    }
}