package carparking.service

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CarParkingServiceImplTest {
    lateinit var carParkingService: CarParkingServiceImpl
    private val outContent = ByteArrayOutputStream()

    @Before
    fun setUpStreams() {
        System.setOut(PrintStream(outContent))
        carParkingService = CarParkingServiceImpl()
    }

    @Test
    @Throws(Exception::class)
    fun testCreateCarParkingLot() {
        carParkingService.createCarParkingLot("6")
        assertEquals(6, carParkingService.MAX_CAPACITY)
        assertEquals(6, carParkingService.availableSlotList.size)
        assertTrue("createdparkinglotofmaximumcapacityof6slots".equals(outContent.toString().trim { it <= ' ' }.replace(" ", ""), ignoreCase = true))
    }

    @After
    fun cleanUpStreams() {
        System.setOut(null)
    }
}