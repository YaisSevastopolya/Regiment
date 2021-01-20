package Main

import Data.EnumMenu
import Unit.*
import Unit.MilitaryUnit

class PlatoonLevel {
    fun platoonLevel() : EnumMenu {
        fun typeChoice(): MilitaryUnit {
            println("Выберите род войск")
            println("1 - Мотострелковые войска")
            println("2 - Танковые войска")
            var platoon: MilitaryUnit = MotorizedPlatoon()
            val playerChoice_a = readLine() ?: ""
            when (playerChoice_a) {
                "1" -> {
                    platoon = MotorizedPlatoon()
                }
                "2" -> {
                    platoon = TankPlatoon()
                }
            }
            return platoon
        }
        val platoon = typeChoice()
        val process = Process()
        while (true) {
            println("Вы командир взвода, выберите действие")
            println("1 - Подсчитать боеспособность")
            println("2 - Просмотреть документацию")
            println("3 - Подготовить рапорт")             //Лог событий за прошедшие сутки
            println("4 - Отдать приказы")                 //Повысить боеспособность своими действиями
            println("5 - Следующий день")
            println("0 - Выйти")
            print(">>> ")
            val playerChoice = readLine() ?: ""
            when (playerChoice) {
                "1" -> println(platoon.combatantValue())      //Возможность подсчёта разных типов боеспособности (ПТО, ПВО и т.д.)?
                "2" -> process.selectDocument(platoon)
                "3" -> process.selectLog(platoon)
                "4" -> process.selectDecision(platoon)
                "5" -> process.selectEvent(platoon)
                "0" -> return EnumMenu.START
                else -> println("Введено неверное значение")
            }
        }
    }
}