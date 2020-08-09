package carparking.service

import carparking.model.Car
import java.util.*
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
                this.slotAndCarMap.put(slot, car)
                this.carRegNoAndSlotMap.put(car.regNo, slot)
                println("Car allocated at slot number: $slot")
                println()
                availableSlotList.removeAt(0)
            }
        }
    }

    override fun leaveCar(carRegNo: String, hours: String) {
        when {
            this.MAX_CAPACITY.equals(0) -> {
                println("Sorry, parking lot is not created")
                println()
            }
            this.slotAndCarMap.size > 0 -> {
                val slotNo: String = this.carRegNoAndSlotMap.get(carRegNo).toString()
                lateinit var carToLeave: Car
                if (!slotNo.equals("null")) {
                    carToLeave = this.slotAndCarMap.get(slotNo)!!

                    if (!carToLeave.equals(null)) {
                        when {
                            !carToLeave.equals(null) -> {
                                this.slotAndCarMap.remove(slotNo)

                                this.carRegNoAndSlotMap.remove(carToLeave.regNo)
                                availableSlotList.add(slotNo.toInt())
                                System.out.println("Registration number " + carToLeave.regNo + " with Slot Number " + slotNo + " with Charge " + getApplicableCharge(hours))
                                println()
                            }
                            else -> {
                                System.out.println("Slot number " + slotNo + " is already empty")
                                println()
                            }
                        }
                    }
                }
            }
            else -> {
                println("Parking lot is empty")
                println()
            }
        }
    }

    override fun carParkingStatus() {
        when {
            this.MAX_CAPACITY.equals(0) -> {
                println("Sorry, parking lot is not created")
                println()
            }
            this.slotAndCarMap.size > 0 -> {

                println("Slot No.\tRegistration No.\tColor")
                var car: Car
                for (i in 1..this.MAX_CAPACITY) {
                    val key = Integer.toString(i)
                    if (this.slotAndCarMap.containsKey(key)) {
                        car = this.slotAndCarMap.get(key)!!
                        println(i.toString() + "\t\t\t" + car.regNo + "\t\t" + car.color)
                    }
                }
                println()
            }
            else -> {
                println("Parking lot is empty")
                println()
            }
        }
    }

    fun getApplicableCharge(hours: String): String {
        var applicableCharge = 10
        val additionalHours = hours.toInt() - 2
        applicableCharge += additionalHours * 10
        return applicableCharge.toString()
    }
}