package carparking

import carparking.model.Car
import carparking.service.CarParkingService
import carparking.service.CarParkingServiceImpl

object CarParkingLot {
    lateinit var carParkingService: CarParkingService

    fun initCarParkingService() {
        carParkingService = CarParkingServiceImpl()
    }

    fun createCarParkingLot(capacity: String) {
        carParkingService.createCarParkingLot(capacity)
    }

    fun parkCar(car: Car) {
        carParkingService.parkCar(car)
    }

    fun leaveCar(carRegNo: String, hours: String) {
        carParkingService.leaveCar(carRegNo, hours)
    }

    fun carParkingStatus() {
        carParkingService.carParkingStatus()
    }
}