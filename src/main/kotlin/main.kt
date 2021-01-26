import Data.EnumMenu
import Main.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket
import java.io.InputStream;



fun main() {
    start()
}

fun start() {
    val mainMenu = MainMenu()
    var menu: EnumMenu = EnumMenu.DEFAULT
    while (true) {
        menu = when (menu) {
            EnumMenu.MAIN_MENU -> mainMenu.mainMenu()
            EnumMenu.START -> mainMenu.startChoice()
            EnumMenu.CONTINUE,
            EnumMenu.SQUAD_LEVEL -> {
                val processSquadLevel = SquadLevel()
                processSquadLevel.squadLevel()
            }
            EnumMenu.PLATOON_LEVEL -> {
                val processPlatoonLevel = PlatoonLevel()
                processPlatoonLevel.platoonLevel()
            }
            EnumMenu.COMPANY_LEVEL -> {
                val processCompanyLevel = CompanyLevel()
                processCompanyLevel.companyLevel()
            }
            EnumMenu.BATTALION_LEVEL -> {
                val processBattalionLevel = BattalionLevel()
                processBattalionLevel.battalionLevel()
            }
            EnumMenu.REGIMENT_LEVEL -> {
                val processRegimentLevel = RegimentLevel()
                processRegimentLevel.regimentLevel()
            }
            EnumMenu.DEFAULT -> mainMenu.mainMenu()
            EnumMenu.EXIT -> break
            EnumMenu.NEW_STEP -> continue
        }
    }
}

object SocketClient {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val clientSocket = Socket("localhost", 50001)
            val `is`: InputStream = clientSocket.getInputStream()
            val br = BufferedReader(InputStreamReader(`is`))
            val receivedData = br.readLine()
            println("Received Data: $receivedData")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}





