import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.InputStream
import java.io.PrintStream

class ReadInputFileTest {
    lateinit var inputStream: InputStream
    private val outContent = ByteArrayOutputStream()

    @Before
    fun setUpStreams() {
        inputStream = File("src/test/resources/file_input.txt").inputStream()
        System.setOut(PrintStream(outContent))
    }


    @Test
    fun readInputFileTextTest() {

        val inputString = inputStream.bufferedReader().use { it.readText() }

        val expectedString = "create_parking_lot 6\n" +
                "park KA-01-HH-1234 White\n" +
                "park KA-01-HH-9999 White\n" +
                "park KA-01-BB-0001 Black\n" +
                "park KA-01-HH-7777 Red\n" +
                "park KA-01-HH-2701 Blue\n" +
                "park KA-01-HH-3141 Black\n" +
                "leave KA-01-HH-3141 4\n" +
                "status\n" +
                "park KA-01-P-0333 White\n" +
                "park DL-12-AA-9999 White\n" +
                "leave KA-01-HH-1234 4\n" +
                "leave KA-01-BB-0001 6\n" +
                "leave DL-12-AA-9999 2\n" +
                "park KA-09-HH-0987 Pink\n" +
                "park CA-09-IO-1111 Yellow\n" +
                "park KA-09-HH-0123 Silver\n" +
                "status"

        Assert.assertEquals(expectedString, inputString)
    }

    @Test
    fun testReadInputFileText() {
        inputStream = File("src/test/resources/file_input1.txt").inputStream()
        readInputFileText(inputStream)
        Assert.assertTrue(
            "Createdparkinglotofmaximumcapacityof6slotsCarallocatedatslotnumber:1".equals(
                outContent.toString().trim { it <= ' ' }.replace(" ", "").replace("\n", "").replace("\r", "")
            )
        )
    }

    @After
    fun cleanUpStreams() {
        System.setOut(null)
        inputStream.close()
    }

}