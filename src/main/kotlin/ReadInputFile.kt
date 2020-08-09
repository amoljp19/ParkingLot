import java.io.File
import java.io.InputStream


fun main() {
    val inputStream: InputStream = File("src/main/resources/file_input.txt").inputStream()

    val inputString = inputStream.bufferedReader().use { it.forEachLine { CommandProcessor.validateCommandAndProcess(it) } }
    println(inputString)
}