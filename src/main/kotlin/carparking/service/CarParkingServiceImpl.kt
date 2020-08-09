package carparking.service

import carparking.model.Car
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


class CarParkingServiceImpl : CarParkingService {

    var MAX_CAPACITY = 0

    lateinit var availableSlotList: ArrayList<Int>

    lateinit var slotAndCarMap: HashMap<String, Car>

    lateinit var carRegNoAndSlotMap: HashMap<String, String>

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

    override fun parkCar(car: Car) {
        when {
            this.MAX_CAPACITY.equals(0) -> {
                println("Sorry, car parking lot is not created, please create it first")
                println()
            }
            this.slotAndCarMap.size.equals(this.MAX_CAPACITY) -> {
                println("Sorry, car parking lot is full")
                println()
            }
            else -> {
                Collections.sort(availableSlotList)
                val slot = availableSlotList[0].toString()
                this.slotAndCarMap.put(slot,car)
                this.carRegNoAndSlotMap.put(car.regNo, slot)
                println("Car allocated at slot number: $slot")
                println()
                availableSlotList.removeAt(0)
            }
        }
    }

    override fun leaveCar(carRegNo: String, hours: String) {
        TODO("Not yet implemented")
    }

    override fun carParkingStatus() {
        TODO("Not yet implemented")
    }
}