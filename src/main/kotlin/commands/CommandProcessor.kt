package commands

import carparking.CarParkingLot

object CommandProcessor {

    fun validateCommandsAndProcess(inputString: String){

        val inputStrList: List<String> = inputString.split(" ")
        if (inputStrList[0] == "") {
            println("Thanks for using the program")
            return
        }
        val command: Commands? = Commands.findByCommandName(inputStrList[0])

        if (command == null) {
            println("Invalid command")
            return
        }

        when(command){
            Commands.CREATE_PARKING_LOT -> {
                if (!inputStrList.size.equals(2)) {
                    throw Exception("Invalid no of arguments for command : $command")
                }
                val maxCapacity = inputStrList[1]
                CarParkingLot.initCarParkingService()
                CarParkingLot.createCarParkingLot(maxCapacity)
            }
            Commands.PARK -> {
                if (!inputStrList.size.equals(3)) {
                    throw Exception("Invalid no of arguments for command : $command")
                }
                val regNo = inputStrList[1]
                val color = inputStrList[2]
                CarParkingLot.parkCar(regNo, color)
                println("Park carparking.model.Car")
            }
            Commands.LEAVE -> {
                if (!inputStrList.size.equals(2)) {
                    throw Exception("Invalid no of arguments for command : $command")
                }
                val slotNo = inputStrList[1]
                CarParkingLot.leaveCar(slotNo)
                println("Leave carparking.model.Car")
            }
            Commands.STATUS -> {
                if(!inputStrList.size.equals(2)) {
                    throw Exception("Invalid no of arguments for command : " + command);
                }
                CarParkingLot.carParkingStatus()
                println("Parking Satus")
            }
        }


    }
}