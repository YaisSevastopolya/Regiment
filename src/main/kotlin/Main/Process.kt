package Main

import Data.EnumMenu
import Main.ProcessVisitor.*
import Unit.MilitaryUnit

class Process {
    var hours = 16
    fun selectDocument(x: MilitaryUnit): EnumMenu {
        println("Выбор: ")
        println("1 - Список личного состава")
        println("2 - Ведомость техники по штату")
        println("3 - Служебные характеристики на подчинённых")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> personnelList(x)
            "2" -> vehicleList(x)
            "3" -> serviceCharacteristic(x)
            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun selectDecision(x: MilitaryUnit): EnumMenu {
        println("Сегодня осталось ${hours} свободных часов")
        println("Выбор: ")
        println("1 - Провести заняттия по боевой подготовке (4 часа)")
        println("2 - Организовать приём пищи (1 час)")
        println("3 - Пополнить боекомплект (8 часов)")
        println("4 - Принять пополнение (2 часа)")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> {
                if (hours >= 4) {
                    training(x)
                    hours -= 4
                    println("Занятие проведено.")
                } else {
                    println("Недостаточно свободного времени!")
                }
            }
            "2" -> {
                if (hours >= 1) {
                    feeding(x)
                    hours -= 1
                    println("Приём пищи окончен.")
                } else {
                    println("Недостаточно свободного времени!")
                }
            }
            "3" -> {
                if (hours >= 8) {
                    ammunition(x)
                    hours -= 8
                    println("БК пополнен.")
                } else {
                    println("Недостаточно свободного времени!")
                }
            }
            "4" -> {
                if (hours >= 2) {
                    reinforcement(x)
                    hours -= 2
                    println("Пополнение принято.")
                } else {
                    println("Недостаточно свободного времени!")
                }
            }
            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun selectLog(x: MilitaryUnit): EnumMenu {
        println("Выбор: ")
        println("1 - Рапорт о текущем состоянии подразделения")  //не реализовано
        //println("2 - Рапорт за прошедшие сутки")  //не реализовано
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> todayReport(x)

            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun selectEvent(x: MilitaryUnit): EnumMenu {
        println("Выбор: ")
        println("1 - Прошёл день")
        println("2 - Боевое столкновение")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> {
                oneDayMore(x)
                hours = 16
                println("День прошёл...")
            }
            "2" -> {
                combatEpisode(x)
                hours = 4
                println("Был тяжёлый бой...")
            }
            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun personnelList(x: MilitaryUnit) {
        println("Список личного состава")
        val visitor = VisitorPersonnelList()
        x.accept(visitor)
    }
    fun vehicleList(x: MilitaryUnit) {
        println("Ведомость техники по штату")
        val visitor = VisitorVehicleList()
        x.accept(visitor)
        visitor.x.forEach {
            println("${it.key} - ${it.value} ед.")
        }
    }
    fun serviceCharacteristic(x: MilitaryUnit) {
        println("Введите номер по списку личного состава: ")
        print(">>> ")
        val visitor = VisitorServiceCharacteristic()
        x.accept(visitor)
    }

    fun training(x: MilitaryUnit) {
        val visitor = VisitorTraining()
        x.accept(visitor)
    }
    fun feeding(x: MilitaryUnit) {
        val visitor = VisitorFeeding()
        x.accept(visitor)
    }
    fun ammunition(x: MilitaryUnit) {
        val visitor = VisitorAmmunition()
        x.accept(visitor)
    }
    fun reinforcement(x: MilitaryUnit) {
        val visitor = VisitorReinforcement()
        x.accept(visitor)
    }

    fun todayReport(x: MilitaryUnit) {
        println("Рапорт о текущем состоянии подразделения")
        val visitor = VisitorTodayReport()
        x.accept(visitor)
        println("Личный состав:")
        visitor.countersInfantry.forEach {
            println("${it.key} - ${it.value} чел.")
        }
        println("Техника:")
        visitor.countersVehicle.forEach {
            println("${it.key} - ${it.value} ед.")
        }
    }

    fun oneDayMore(x: MilitaryUnit) {
        val visitor = VisitorOneDayMore()
        x.accept(visitor)
    }
    fun combatEpisode(x: MilitaryUnit) {
        val visitor = VisitorCombatEpisode()
        x.accept(visitor)
    }
}