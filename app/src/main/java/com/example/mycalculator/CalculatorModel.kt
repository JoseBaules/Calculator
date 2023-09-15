import kotlin.math.round
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class CalculatorModel {
    fun performOperation(string: String): String {


        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        var result = engine.eval(string)


        if (result.toString() =="Infinity" || result.toString() == "-Infinity" || result.toString() =="NaN")        {
            return "Error"
        }

        if (!result.toString().contains("E"))
        {
            var round = round(result as Double * 10) /10
            return round.toString()
        }

        return result.toString()
    }

    fun removeTrailingZeros(result: String): String {
        var value = result
        var notation =""
        if (result.contains(".0") && !result.contains("E"))
        {

            value = result.substring(0, result.length - 2)
        }

        if (result.contains("E"))
        {
            value = result.replace(".0","")
        }
        return value
    }

}
