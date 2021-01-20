package Decisions

import Data.Data
import InfantryUnit.InfantryUnit

object PersonnelList {
    fun personnelListInfantry(infantryUnit: InfantryUnit) {
        println("${(Data.database[infantryUnit.position] ?: error("")).position} ${infantryUnit.fullName}")
    }
}