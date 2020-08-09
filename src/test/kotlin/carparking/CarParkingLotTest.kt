package carparking

import org.junit.Assert
import org.junit.Test

class CarParkingLotTest {
    @Test
    fun testInitCarParkingService() {
        CarParkingLot.initCarParkingService()
        Assert.assertNotNull(CarParkingLot.carParkingService)
    }
}