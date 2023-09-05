class CalculatorModel {
    fun performOperation(operationString: String): String {
        var result = ""
        try {
            val prefix = if (operationString.startsWith("-")) "-" else ""
            val expression = operationString.removePrefix("-")
            when {
                expression.contains("-") -> {
                    val splitExpression = expression.split("-")
                    val numA = splitExpression[0].toDouble()
                    val numB = splitExpression[1].toDouble()
                    result = (numA - numB).toString()
                }
                expression.contains("+") -> {
                    val splitExpression = expression.split("+")
                    val numA = splitExpression[0].toDouble()
                    val numB = splitExpression[1].toDouble()
                    result = (numA + numB).toString()
                }
                expression.contains("*") -> {
                    val splitExpression = expression.split("*")
                    val numA = splitExpression[0].toDouble()
                    val numB = splitExpression[1].toDouble()
                    result = (numA * numB).toString()
                }
                expression.contains("/") -> {
                    val splitExpression = expression.split("/")
                    val numA = splitExpression[0].toDouble()
                    val numB = splitExpression[1].toDouble()
                    if (numB != 0.0) {
                        result = (numA / numB).toString()
                    } else {
                        result = "Error"
                    }
                }
            }
        } catch (e: ArithmeticException) {
            e.printStackTrace()
            result = "Error"
        }
        return result
    }

    fun removeTrailingZeros(result: String): String {
        var value = result
        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }
        return value
    }

    fun isOperatorAdded(value: String): Boolean {
        return value.startsWith("-") || value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
    }
}
