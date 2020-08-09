


object CommandProcessor {

    fun validateCommandsAndProcess(inputString: String){

        val inputStrArr: List<String> = inputString.split(" ")
        if (inputStrArr[0] == "") {
            println("Thanks for using the program")
            return
        }
        val command: Commands? = Commands.findByCommandName(inputStrArr[0])

        if (command == null) {
            println("Invalid command")
            return
        }

        when(command){
            Commands.CREATE_PARKING_LOT -> {
                println("Car Parking Lot created")
            }
            Commands.PARK -> {
                println("Park Car")
            }
            Commands.LEAVE -> {
                println("Leave Car")
            }
            Commands.STATUS -> {
                println("Parking Satus")
            }
        }


    }
}