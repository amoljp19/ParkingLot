import java.util.*


class CarParkingServiceImpl : CarParkingService {

    var MAX_CAPACITY = 0

    lateinit var availableSlotList: ArrayList<Int>

    lateinit var slotAndCarMap: Map<String, Car>

    lateinit var carRegNoAndSlotMap: Map<String, String>

    override fun createCarParkingLot(capacity: String) {
        try {
            this.MAX_CAPACITY = capacity.toInt()
        } catch (e: Exception) {
            println("Invalid car parking lot capacity")
            println()
        }
        availableSlotList = object : ArrayList<Int>() {}
        for (i in 1..this.MAX_CAPACITY) {
            availableSlotList.add(i)
        }
        this.slotAndCarMap = HashMap<String, Car>()
        this.carRegNoAndSlotMap = HashMap<String, String>()
        System.out.println("Created parking lot of maximum capacity of " + capacity + " slots")
        println()
    }

    override fun parkCar(regNo: String, color: String) {
        TODO("Not yet implemented")
    }

    override fun leaveCar(slotNo: String) {
        TODO("Not yet implemented")
    }

    override fun carParkingStatus() {
        TODO("Not yet implemented")
    }
}