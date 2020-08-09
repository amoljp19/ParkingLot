
import java.util.*


class CarParkingServiceImpl : CarParkingService {

    lateinit var availableSlotList: ArrayList<Int>

    lateinit var slotAndCarMap: Map<String, Car>

    lateinit var carRegNoAndSlotMap: Map<String, String>

    override fun createParkingLot(capacity: String) {
        TODO("Not yet implemented")
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