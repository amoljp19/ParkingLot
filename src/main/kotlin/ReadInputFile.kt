import commands.CommandProcessor
import java.io.File
import java.io.InputStream


fun main() {
    val inputStream: InputStream = File("src/main/resources/file_input.txt").inputStream()
    readInputFileText(inputStream)
}

fun readInputFileText(inputStream: InputStream) {
    inputStream.bufferedReader().use { it.forEachLine { CommandProcessor.validateCommandsAndProcess(it) } }
}