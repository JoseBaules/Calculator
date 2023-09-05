package com.example.mycalculator

interface CalculatorView
{
    fun appendText(text:String)
    fun clearText()
    fun getCurrentText():String
    fun displayResult(result:String)

}