import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class CalculatorModel {
    fun performOperation(string: String): String {

        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        val result = engine.eval(string)

        if (result.toString() =="Infinity" || result.toString() == "-Infinity")
        {
            return "Error"
        }

        return result.toString()
    }

    fun removeTrailingZeros(result: String): String {
        var value = result
        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }
        return value
    }


}
