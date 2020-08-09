object CarParkingLot {
    lateinit var carParkingService: CarParkingService

    fun initCarParkingService(){
        carParkingService = CarParkingServiceImpl()
    }
}