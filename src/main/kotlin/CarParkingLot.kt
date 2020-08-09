object CarParkingLot {
    lateinit var carParkingService: CarParkingService

    fun initCarParkingService(){
        carParkingService = CarParkingServiceImpl()
    }

    fun createParkingLot(capacity:String){
        carParkingService.createParkingLot(capacity)
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