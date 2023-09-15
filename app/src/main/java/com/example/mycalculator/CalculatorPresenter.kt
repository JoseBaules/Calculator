package com.example.mycalculator

import CalculatorModel

class CalculatorPresenter(private val model: CalculatorModel, private val view: CalculatorView) {

    private var lastNumeric = true
    private var lastDot = false
    private var oneDot = false
    private var minus = false

    //
    fun onDigitClicked(text: String) {
        if (view.getCurrentText() =="0")
        {
            view.clearZero()
            view.appendText(text)
            lastNumeric = true

        }
        else{
            view.appendText(text)
            lastNumeric = true
            lastDot = false
        }
    }


    fun onClearClicked() {
        view.clearText()
        lastNumeric = true
    }

    fun onBackSpaceClicked()
    {
        view.backSpace()
        lastNumeric = true

    }
    fun onDecimalClicked() {
        if (lastNumeric && !lastDot) {
            view.appendText(".")
            lastNumeric = false
            lastDot = true
            oneDot = true
        }
    }

    fun onOperatorClicked(text: String) {

        if (lastNumeric)
        {
            view.appendText(text)
            lastNumeric = false
            lastDot = false

        }
    }

    fun onEqualClicked() {
        val currentText = view.getCurrentText()
        if (lastNumeric) {
            val result = model.performOperation(currentText)
            view.displayResult(model.removeTrailingZeros(result))
        }
    }
}
