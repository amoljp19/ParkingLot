package commands

enum class Commands(val commandName: String) {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    STATUS("status");

    fun equalsName(otherCommandName: String): Boolean {
        return commandName == otherCommandName
    }

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

        fun <T : Enum<T>?> getEnumFromString(c: Class<T>?, string: String?): T? {
            if (c != null && string != null) {
                try {
                    return java.lang.Enum.valueOf(c, string.trim { it <= ' ' }.toUpperCase())
                } catch (ex: IllegalArgumentException) {
                }
            }
            return null
        }
    }

}