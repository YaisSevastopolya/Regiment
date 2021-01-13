package Decisions

import CommandUnit.CommandUnit
import Data.Data
import InfantryUnit.InfantryUnit

object PersonnelList {
    fun personnelListCommand(commandUnit: CommandUnit) {
        println("${(Data.database[commandUnit.position] ?: error("")).position} ${commandUnit.fullName()}")
    }
    fun personnelListInfantry(infantryUnit: InfantryUnit) {
        println("${(Data.database[infantryUnit.position] ?: error("")).position} ${infantryUnit.fullName()}")
    }
}