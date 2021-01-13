package Main

import Data.EnumMenu
import Unit.*
import Unit.Unit

class CompanyLevel {
    fun companyLevel() : EnumMenu {
        fun typeChoice(): Unit {
            println("Выберите род войск")
            println("1 - Мотострелковые войска")
            println("2 - Танковые войска")
            var company: Unit = MotorizedCompany()
            val playerChoice_a = readLine() ?: ""
            when (playerChoice_a) {
                "1" -> {
                    company = MotorizedCompany()
                }
                "2" -> {
                    company = TankCompany()
                }
            }
            return company
        }
        val company = typeChoice()
        val process = Process()
        while (true) {
            println("Вы командир роты, выберите действие")
            println("1 - Подсчитать боеспособность")
            println("2 - Вывести список личного состава")
            println("3 - Подготовить рапорт")             //Лог событий за прошедшие сутки
            println("4 - Отдать приказы")                 //Повысить боеспособность своими действиями
            println("5 - Следующий день")
            println("0 - Выйти")
            print(">>> ")
            val playerChoice = readLine() ?: ""
            when (playerChoice) {
                "1" -> println(company.combatantValue())      //Возможность подсчёта разных типов боеспособности (ПТО, ПВО и т.д.)?
                "2" -> process.personnelList(company)

                "5" -> process.selectEvent(company)
                "0" -> return EnumMenu.START
                else -> println("Введено неверное значение")
            }
        }
    }
}