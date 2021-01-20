package Decisions

import CommandUnit.CommandUnit
import Data.Data
import Data.Percent
import InfantryUnit.InfantryUnit

object Reinforcement {
    fun reinforcementCommand(commandUnit: CommandUnit) {
        if (commandUnit.isKilled || commandUnit.isArrested) {
            commandUnit.name = Data.name.random()
            commandUnit.surname = Data.surname.random()
            commandUnit.patronymic = Data.patronymic.random()
            commandUnit.isIll = false
            commandUnit.isWounded = false
            commandUnit.isKilled = false
            commandUnit.isArrested = false
            commandUnit.isFed = Percent(100)
            commandUnit.isArmed = true
            commandUnit.isEquipped = Percent(100)
            commandUnit.isTrained = Percent(50)
            commandUnit.isBattleTried = false
            commandUnit.combatExperience = Percent(0)
            commandUnit.vehicleDriverExperience = Percent(100)
            commandUnit.vehicleCombatDriverExperience = Percent(0)
            commandUnit.isAlcoholic = false
            commandUnit.isSportsman = false

            commandUnit.commandExperience = Percent(100)
            commandUnit.commandCombatExperience = Percent(0)
        }
    }

    fun reinforcementInfantry(infantryUnit: InfantryUnit) {
        if (infantryUnit.isKilled || infantryUnit.isArrested) {
            infantryUnit.name = Data.name.random()
            infantryUnit.surname = Data.surname.random()
            infantryUnit.patronymic = Data.patronymic.random()
            infantryUnit.isIll = false
            infantryUnit.isWounded = false
            infantryUnit.isKilled = false
            infantryUnit.isArrested = false
            infantryUnit.isFed = Percent(100)
            infantryUnit.isArmed = true
            infantryUnit.isEquipped = Percent(100)
            infantryUnit.isTrained = Percent(50)
            infantryUnit.isBattleTried = false
            infantryUnit.combatExperience = Percent(0)
            if (infantryUnit.position == "driverMechanic" || infantryUnit.position == "gunnerOperator") {
                infantryUnit.vehicleDriverExperience = Percent(100)
            } else {
                infantryUnit.vehicleDriverExperience = Percent(0)
            }
            infantryUnit.vehicleCombatDriverExperience = Percent(0)
            infantryUnit.isAlcoholic = false
            infantryUnit.isSportsman = false
        }
    }
}