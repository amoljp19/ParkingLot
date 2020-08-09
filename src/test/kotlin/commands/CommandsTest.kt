package commands

import javafx.scene.web.HTMLEditorSkin.Command
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test


class CommandsTest {

    @Test
    @Throws(Exception::class)
    fun testInCorrectCommand() {
        val command: Commands? = Commands.findByCommandName("create_parking_lot_for_truck")
        assertTrue(command == null)
    }

    @Test
    @Throws(Exception::class)
    fun testCorrectCommand() {
        val command: Commands? = Commands.findByCommandName("create_parking_lot")
        assertTrue(command != null)
        assertEquals("create_parking_lot", command?.commandName)
    }


}