package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity()
{
    private var textResult: TextView? = null
    var lastNumeric : Boolean = false
    var lastDot: Boolean = false
    var oneDot:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textResult)
    }

    fun onDigit(view: View)
    {
        textResult?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }
    fun onClear(view: View)
    {
        textResult?.text = ""
    }

    fun onDecimal(view: View)
    {
        if (lastNumeric && !lastDot && !oneDot)
        {
            textResult?.append(".")
            lastNumeric = false
            lastDot = true
            oneDot = true

        }
    }

    fun onOperator(view: View)
    {
        textResult?.text?.let {

            if (lastNumeric && !isOperatorAdded(it.toString()))
            {
                textResult?.append(( view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    fun onEqual (view: View)
    {
        if (lastNumeric)
        {
            var operationString = textResult?.text.toString()
            var prefix = ""
            try {

                if (operationString.startsWith("-"))
                {
                    prefix = "-"
                    operationString = operationString.substring(1)
                }
                if (operationString.contains("-"))
                {
                    val splitExpression = operationString.split("-")
                    var numA = splitExpression[0]
                    var numB = splitExpression[1]

                    if (prefix.isNotEmpty())
                    {
                        numA = prefix + numA
                    }

                    textResult?.text = removeZero((numA.toDouble() - numB.toDouble()).toString())
                } else if (operationString.contains("+"))
                {
                    val splitExpression = operationString.split("+")
                    var numA = splitExpression[0]
                    var numB = splitExpression[1]

                    if (prefix.isNotEmpty())
                    {
                        numA = prefix + numA
                    }

                    textResult?.text = removeZero((numA.toDouble() + numB.toDouble()).toString())
                } else if (operationString.contains("*"))
                {
                    val splitExpression = operationString.split("*")
                    var numA = splitExpression[0]
                    var numB = splitExpression[1]

                    if (prefix.isNotEmpty())
                    {
                        numA = prefix + numA
                    }

                    textResult?.text = removeZero((numA.toDouble() * numB.toDouble()).toString())
                }else if (operationString.contains("/"))
                {
                    val splitExpression = operationString.split("/")
                    var numA = splitExpression[0]
                    var numB = splitExpression[1]

                    if (prefix.isNotEmpty())
                    {
                        numA = prefix + numA
                    }

                    textResult?.text = removeZero((numA.toDouble() / numB.toDouble()).toString())
                }

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    fun removeZero(result: String) : String
    {
        var value = result
        if (result.contains(".0"))
        {
            value = result.substring(0,result.length-2)
        }

        return value
    }



    private fun isOperatorAdded(value:String):Boolean
    {
        return if(value.startsWith("-"))
        {
            false
        }else{
            value.contains("/")
                    ||value.contains("*")
                    ||value.contains("+")
                    ||value.contains("-")
        }
    }



}