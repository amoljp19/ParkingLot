import commands.CommandProcessor
import java.io.File
import java.io.InputStream


fun main(args: Array<String>) {
    if (args.size == 0) {
        println("Please provide a name as a command-line argument")
        return
    }
    val inputStream: InputStream = File(System.getProperty("user.dir") + "/${args[0]}").inputStream()
    readInputFileText(inputStream)
}

fun readInputFileText(inputStream: InputStream) {
    inputStream.bufferedReader().use { it.forEachLine { CommandProcessor.validateCommandsAndProcess(it) } }
}