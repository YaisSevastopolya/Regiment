package Main

import Data.EnumMenu
import Main.ProcessVisitor.VisitorCombatEpisode
import Main.ProcessVisitor.VisitorOneDayMore
import Main.ProcessVisitor.VisitorPersonnelList
import Unit.Unit

class Process {
    fun selectEvent(x: Unit): EnumMenu {
        println("Выбор: ")
        println("1 - Прошёл день")
        println("2 - Боевое столкновение")
        println("0 - Выйти")
        print(">>> ")
        val playerChoice = readLine() ?: ""
        when (playerChoice) {
            "1" -> oneDayMore(x)
            "2" -> combatEpisode(x)
            "0" -> return EnumMenu.EXIT
            else -> println("Введено неверное значение")
        }
        return EnumMenu.DEFAULT
    }

    fun personnelList(x: Unit) {
        val visitor = VisitorPersonnelList()
        x.accept(visitor)
    }
    fun oneDayMore(x: Unit) {
        val visitor = VisitorOneDayMore()
        x.accept(visitor)
    }
    fun combatEpisode(x: Unit) {
        val visitor = VisitorCombatEpisode()
        x.accept(visitor)
    }
}