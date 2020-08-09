package carparking.service

interface CarParkingService {
    fun createCarParkingLot(capacity:String)

    fun parkCar(regNo: String, color: String)

    fun leaveCar(slotNo: String)

    fun carParkingStatus()
}