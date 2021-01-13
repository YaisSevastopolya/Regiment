package Main

import Data.EnumMenu

class MainMenu {
    fun mainMenu(): EnumMenu {
        println("Главное меню")
        println("1 - Начать")
        println("2 - Продолжить")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> return EnumMenu.START
            "2" -> return EnumMenu.CONTINUE //Продолжить с последнего действия, не реализовано
            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun startChoice(): EnumMenu {
        println("Выберите уровень")
        println("1 - Командир отделения")
        println("2 - Командир взвода")
        println("3 - Командир роты")
        println("4 - Командир батальона")
        println("5 - Командир полка")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> return EnumMenu.SQUAD_LEVEL
            "2" -> return EnumMenu.PLATOON_LEVEL
            "3" -> return EnumMenu.COMPANY_LEVEL
            "4" -> return EnumMenu.BATTALION_LEVEL
            "5" -> return EnumMenu.REGIMENT_LEVEL
            "0" -> return EnumMenu.MAIN_MENU
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }
}