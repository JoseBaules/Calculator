package com.example.mycalculator

import CalculatorModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity(), CalculatorView
{
    private var textResult: TextView? = null

    private val calculatorModel = CalculatorModel()

    private val calculatorPresenter = CalculatorPresenter(calculatorModel,this)


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textResult = findViewById(R.id.textResult)
        textResult?.text ="0"

    }

    override fun appendText(text: String) {

        textResult?.append(text)
    }

    override fun clearText() {
        textResult?.text = "0"
    }

    override fun clearZero()
    {
        textResult?.text =""
    }

    override fun backSpace() {
        if (textResult?.text.toString().isNotEmpty())
            textResult?.text = textResult?.text.toString().substring(0,textResult?.text.toString().length-1)
        if (textResult?.text.toString().isEmpty())
            clearText()

    }
    override fun getCurrentText(): String {

        return textResult?.text.toString()
    }

    override fun displayResult(result: String) {
        textResult?.text = result

    }

    fun onDigit(view: View) {
        val buttonText = (view as Button).text.toString()
        calculatorPresenter.onDigitClicked(buttonText)
    }

    fun onClear(view: View) {
        calculatorPresenter.onClearClicked()
    }
    fun onBack (view: View)
    {
        calculatorPresenter.onBackSpaceClicked()
    }

    fun onDecimal(view: View) {
        calculatorPresenter.onDecimalClicked()
    }

    fun onOperator(view: View) {
        val buttonText = (view as Button).text.toString()
        calculatorPresenter.onOperatorClicked(buttonText)
    }

    fun onEqual(view: View) {
        calculatorPresenter.onEqualClicked()
    }


}