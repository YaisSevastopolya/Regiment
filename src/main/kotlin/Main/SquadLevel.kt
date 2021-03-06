package Main

import Data.EnumMenu
import Unit.MotorizedSquad
import Unit.TankSquad
import Unit.MilitaryUnit

class SquadLevel {
    fun squadLevel() : EnumMenu {
        fun typeChoice(): MilitaryUnit {
            println("Выберите род войск")
            println("1 - Мотострелковые войска")
            println("2 - Танковые войска")
            var squad: MilitaryUnit = MotorizedSquad()
            val playerChoice_a = readLine() ?: ""
            when (playerChoice_a) {
                "1" -> {
                    squad = MotorizedSquad()
                }
                "2" -> {
                    squad = TankSquad()
                }
            }
            return squad
        }
        val squad: MilitaryUnit = typeChoice()
        val process = Process()
        while (true) {
            println("Вы командир отделения, выберите действие")
            println("1 - Подсчитать боеспособность")
            println("2 - Просмотреть документацию")
            println("3 - Подготовить рапорт")             //Лог событий за прошедшие сутки
            println("4 - Отдать приказы")                 //Повысить боеспособность своими действиями, ограниченное количество часов
            println("5 - Следующий день")
            println("0 - Выйти")
            print(">>> ")
            val playerChoice_b = readLine() ?: ""
            when (playerChoice_b) {
                "1" -> println(squad.combatantValue())      //Возможность подсчёта разных типов боеспособности (ПТО, ПВО и т.д.)?
                "2" -> process.selectDocument(squad)
                "3" -> process.selectLog(squad)
                "4" -> process.selectDecision(squad)
                "5" -> process.selectEvent(squad)
                "0" -> return EnumMenu.START
                else -> println("Введено неверное значение")
            }
        }
    }
}