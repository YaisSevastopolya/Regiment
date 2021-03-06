package Main

import Data.EnumMenu
import Unit.MotorizedBattalion
import Unit.TankBattalion
import Unit.MilitaryUnit

class BattalionLevel {
    fun battalionLevel() : EnumMenu {
        fun typeChoice(): MilitaryUnit {
            println("Выберите род войск")
            println("1 - Мотострелковые войска")
            println("2 - Танковые войска")
            var battalion: MilitaryUnit = MotorizedBattalion()
            val playerChoice_a = readLine() ?: ""
            when (playerChoice_a) {
                "1" -> {
                    battalion = MotorizedBattalion()
                }
                "2" -> {
                    battalion = TankBattalion()
                }
            }
            return battalion
        }
        val battalion = typeChoice()
        val process = Process()
        while (true) {
            println("Вы командир батальона, выберите действие")
            println("1 - Подсчитать боеспособность")
            println("2 - Просмотреть документацию")
            println("3 - Подготовить рапорт")             //Лог событий за прошедшие сутки
            println("4 - Отдать приказы")                 //Повысить боеспособность своими действиями
            println("5 - Следующий день")
            println("0 - Выйти")
            print(">>> ")
            val playerChoice = readLine() ?: ""
            when (playerChoice) {
                "1" -> println(battalion.combatantValue())      //Возможность подсчёта разных типов боеспособности (ПТО, ПВО и т.д.)?
                "2" -> process.selectDocument(battalion)
                "3" -> process.selectLog(battalion)
                "4" -> process.selectDecision(battalion)
                "5" -> process.selectEvent(battalion)
                "0" -> return EnumMenu.START
                else -> println("Введено неверное значение")
            }
        }
    }
}