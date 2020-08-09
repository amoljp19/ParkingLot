package commands

import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CommandProcessorTest {

    private val outContent = ByteArrayOutputStream()

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
    }

    @Test
    fun testValidateCommandAndProcess(){
        CommandProcessor.validateCommandsAndProcess("create_parking_lot 6")
        assertTrue("createdparkinglotofmaximumcapacityof6slots".equals(outContent.toString().trim { it <= ' ' }.replace(" ", ""), ignoreCase = true))
    }

    @After
    fun cleanUpStreams() {
        System.setOut(null)
    }
}