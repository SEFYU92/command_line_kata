import java.util.regex.Pattern
import kotlin.streams.toList

class CommandLineParser {
    fun parse(commandLine: String): List<Argument> {
        return commandLine.split("-").drop(1).stream().map {
            val argWords = it.split(" ")
            when {
                argWords.get(1).isBlank() -> {
                    return@map Argument(Type.Boolean, true)
                }
                isNumeric(argWords[1]) -> {
                    return@map Argument(Type.Integer, argWords[1].toInt())
                }
                else -> {
                    return@map Argument(Type.Text, argWords[1])
                }
            }
        }.toList()
    }

    private fun isNumeric(strNum: String?): Boolean {
        return if (strNum == null) {
            false
        } else Pattern.compile("-?\\d+").matcher(strNum).matches()
    }

}