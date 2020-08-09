package commands

enum class Commands(val commandName: String) {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status");

    override fun toString(): String {
        return commandName
    }

    companion object {
        fun findByCommandName(cmndName: String): Commands? {
            for (command in values()) {
                if (command.toString() == cmndName) {
                    return command
                }
            }
            return null
        }
    }

}