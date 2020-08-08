import org.junit.Assert
import org.junit.Test
import java.io.File
import java.io.InputStream

class ReadInputFileTest {


    @Test
    fun readInputFileLineTest() {
        val inputStream: InputStream = File("src/test/resources/file_input.txt").inputStream()

        val inputString = inputStream.bufferedReader().use { it.readText() }

        val expectedString = "create_parking_lot 6\n" +
                "park KA-01-HH-1234\n" +
                "park KA-01-HH-9999\n" +
                "park KA-01-BB-0001\n" +
                "park KA-01-HH-7777\n" +
                "park KA-01-HH-2701\n" +
                "park KA-01-HH-3141\n" +
                "leave KA-01-HH-3141 4\n" +
                "status\n" +
                "park KA-01-P-333\n" +
                "park DL-12-AA-9999\n" +
                "leave KA-01-HH-1234 4\n" +
                "leave KA-01-BB-0001 6\n" +
                "leave DL-12-AA-9999 2\n" +
                "park KA-09-HH-0987\n" +
                "park CA-09-IO-1111\n" +
                "park KA-09-HH-0123\n" +
                "status"

        Assert.assertEquals(expectedString, inputString)
    }
}