package Main

import Data.EnumMenu
import Unit.*
import Unit.Unit

class RegimentLevel {
    fun regimentLevel() : EnumMenu {
        fun typeChoice(): Unit {
            println("Выберите род войск")
            println("1 - Мотострелковые войска")
            println("2 - Танковые войска")
            var regiment: Unit = MotorizedRegiment()
            val playerChoice_a = readLine() ?: ""
            when (playerChoice_a) {
                "1" -> {
                    regiment = MotorizedRegiment()
                }
                "2" -> {
                    regiment = TankRegiment()
                }
            }
            return regiment
        }
        val regiment = typeChoice()
        val process = Process()
        while (true) {
            println("Вы командир полка, выберите действие")
            println("1 - Подсчитать боеспособность")
            println("2 - Вывести список личного состава")
            println("3 - Подготовить рапорт")             //Лог событий за прошедшие сутки
            println("4 - Отдать приказы")                 //Повысить боеспособность своими действиями
            println("5 - Следующий день")
            println("0 - Выйти")
            print(">>> ")
            val playerChoice = readLine() ?: ""
            when (playerChoice) {
                "1" -> println(regiment.combatantValue())      //Возможность подсчёта разных типов боеспособности (ПТО, ПВО и т.д.)?
                "2" -> process.personnelList(regiment)

                "5" -> process.selectEvent(regiment)
                "0" -> return EnumMenu.START
                else -> println("Введено неверное значение")
            }
        }
    }
}