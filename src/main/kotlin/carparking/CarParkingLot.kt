package carparking

import carparking.service.CarParkingService
import carparking.service.CarParkingServiceImpl

object CarParkingLot {
    lateinit var carParkingService: CarParkingService

    fun initCarParkingService(){
        carParkingService = CarParkingServiceImpl()
    }

    fun createCarParkingLot(capacity:String){
        carParkingService.createCarParkingLot(capacity)
    }

    fun parkCar(regNo: String, color: String){
        carParkingService.parkCar(regNo, color)
    }

    fun leaveCar(slotNo: String){
        carParkingService.leaveCar(slotNo)
    }

    fun carParkingStatus(){
        carParkingService.carParkingStatus()
    }
}