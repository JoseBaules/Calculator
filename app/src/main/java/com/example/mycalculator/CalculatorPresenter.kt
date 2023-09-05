package com.example.mycalculator

import CalculatorModel

class CalculatorPresenter(private val model: CalculatorModel, private val view: CalculatorView) {

    private var lastNumeric = false
    private var lastDot = false
    private var oneDot = false

    fun onDigitClicked(text: String) {
        view.appendText(text)
        lastNumeric = true
        lastDot = false
    }

    fun onClearClicked() {
        view.clearText()
    }

    fun onDecimalClicked() {
        if (lastNumeric && !lastDot && !oneDot) {
            view.appendText(".")
            lastNumeric = false
            lastDot = true
            oneDot = true
        }
    }

    fun onOperatorClicked(text: String) {
        val currentText = view.getCurrentText()
        if (lastNumeric && !model.isOperatorAdded(currentText)) {
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
