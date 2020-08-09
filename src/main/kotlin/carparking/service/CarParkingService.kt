package carparking.service

import carparking.model.Car

interface CarParkingService {
    fun createCarParkingLot(capacity: String)

    fun parkCar(car: Car)

    fun leaveCar(carRegNo: String, hours: String)

    fun carParkingStatus()
}