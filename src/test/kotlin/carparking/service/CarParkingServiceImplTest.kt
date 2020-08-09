package carparking.service

import carparking.model.Car
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

    @Test
    @Throws(Exception::class)
    fun testParkCar() {
        carParkingService.parkCar(Car("KA-01-HH-1234", "White"))
        assertEquals("Sorry,carparkinglotisnotcreated,pleasecreateitfirst\n".trimIndent(), outContent.toString().trim { it <= ' ' }.replace(" ", ""))
        carParkingService.createCarParkingLot("6")
        carParkingService.parkCar(Car("KA-01-HH-1234", "White"))
        carParkingService.parkCar(Car("KA-01-HH-9999", "White"))
        assertEquals(4, carParkingService.availableSlotList.size)
    }

    @Test
    @Throws(Exception::class)
    fun testLeaveCar() {
        carParkingService.leaveCar("KA-01-HH-1234", "3")
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim { it <= ' ' }.replace(" ", ""))
        carParkingService.createCarParkingLot("6")
        carParkingService.parkCar(Car("KA-01-HH-1234", "White"))
        carParkingService.parkCar(Car("KA-01-HH-9999", "White"))
        carParkingService.leaveCar("KA-01-HH-9999", "2")
        assertEquals("Sorry,parkinglotisnotcreatedCreatedparkinglotofmaximumcapacityof6slotsCarallocatedatslotnumber:1Carallocatedatslotnumber:2RegistrationnumberKA-01-HH-9999withSlotNumber2withCharge10".trimIndent(), outContent.toString().trim { it <= ' ' }.replace(" ", "").replace("\n", "").replace("\r", ""))
    }

    @Test
    @Throws(Exception::class)
    fun testCarParkingStatus() {
        carParkingService.carParkingStatus()
        assertEquals("Sorry,parkinglotisnotcreated", outContent.toString().trim { it <= ' ' }.replace(" ", ""))
        carParkingService.createCarParkingLot("6")
        carParkingService.parkCar(Car("KA-01-HH-1234", "White"))
        carParkingService.parkCar(Car("KA-01-HH-9999", "White"))
        carParkingService.carParkingStatus()
        assertEquals("Sorry,parkinglotisnotcreatedCreatedparkinglotofmaximumcapacityof6slotsCarallocatedatslotnumber:1Carallocatedatslotnumber:2SlotNo.RegistrationNo.Color1KA-01-HH-1234White2KA-01-HH-9999White".trimIndent(), outContent.toString().trim { it <= ' ' }.replace(" ", "").replace("\n", "").replace("\r", "").replace("\t", ""))
    }

    @Test
    fun testGetApplicableCharge(){
        assertEquals("60", carParkingService.getApplicableCharge("7"))
    }


    @After
    fun cleanUpStreams() {
        System.setOut(null)
    }
}