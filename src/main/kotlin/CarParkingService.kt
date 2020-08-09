interface CarParkingService {
    fun createParkingLot(capacity:String)

    fun parkCar(regNo: String, color: String)

    fun leaveCar(slotNo: String)

    fun carParkingStatus()
}