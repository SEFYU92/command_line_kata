import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CommandLineParserTest {
    @Test
    internal fun should_serialise_command_line() {
        val commandLine = "-l -p 8080 -d /usr/logs"
        val parser = CommandLineParser()
        val argList = parser.parse(commandLine)
        assertEquals(3, argList.size)
        assertEquals(Type.Boolean, argList.first().type)
        assertEquals(Type.Integer, argList[1].type)
        assertEquals(Type.Text, argList.last().type)
    }
}