package Unit

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import Main.ProcessVisitor.UnitVisitor
import VehicleUnit.VehicleUnit

interface Unit {
    val structureCommand: List<CommandUnit>
    fun unitCommandEfficiency(): Double {
        var commandEfficiency = structureCommand[0].commandEfficiency()
        for (i in structureCommand) {
            commandEfficiency += i.commandEfficiency()
        }
        commandEfficiency /= (structureCommand.size + 1).toDouble()
        return commandEfficiency
    }
    fun combatantValueCommandSum(): Double {
        var combatantValue = 0.0
        for (i in structureCommand) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    val structureInfantry: List<InfantryUnit>
    fun combatantValueInfantrySum(): Double {
        var combatantValue = 0.0
        for (i in structureInfantry) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    val structureVehicle: List<VehicleUnit>
    val maxCrew: Int
    val minCrew: Int
    fun vehicleEfficiency(): Double {
        val vehicleNum = structureVehicle.size
        val driversSkill = mutableListOf<Double>()
        for (i in structureCommand) {
            if (i.vehicleDriverExperience.toDouble() > 50.0 && i.inOrder) {
                driversSkill.add(i.vehicleDriverEfficiency())
            }
        }
        for (i in structureInfantry ) {
            if (i.vehicleDriverExperience.toDouble() > 50.0 && i.inOrder) {
                driversSkill.add(i.vehicleDriverEfficiency())
            }
        }
        var driverNum = driversSkill.size
        val vehicleEfficiency: Double
        if (driverNum > 0 && vehicleNum > 0) {
            driversSkill.sortDescending()
            val bestDrivers = driversSkill.take(maxCrew * vehicleNum)
            val vehicleDriverEfficiency = bestDrivers.average()
            driverNum = bestDrivers.size
            vehicleEfficiency = vehicleDriverEfficiency * ((driverNum / minCrew.toDouble()) / vehicleNum)
        } else {
            vehicleEfficiency = 0.0
        }
        return vehicleEfficiency
    }
    fun vehicleSupportEfficiency(): Double {
        val vehicleSupportEfficiency = 1 + (vehicleEfficiency() - 1) / 5
        return vehicleSupportEfficiency
    }
    fun combatantValueVehicleSum(): Double {
        var combatantValue = 0.0
        for (i in structureVehicle) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    val structureUnit: List<Unit>
    fun combatantValueUnitSum(): Double {
        var combatantValue = 0.0
        for (i in structureUnit) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    fun combatantValue() : Double {
        val combatantValue = (
                (combatantValueCommandSum() * vehicleSupportEfficiency())
                + (combatantValueInfantrySum() * vehicleSupportEfficiency())
                + (combatantValueVehicleSum() * vehicleEfficiency())
                + combatantValueUnitSum()
                ) * unitCommandEfficiency()
        return combatantValue
    }
    fun accept(visitor: UnitVisitor) {
        visitor.visit(this)
        structureCommand.forEach{
            it.accept(visitor)
        }
        structureInfantry.forEach{
            it.accept(visitor)
        }
        structureVehicle.forEach{
            it.accept(visitor)
        }
        structureUnit.forEach{
            it.accept(visitor)
        }
    }
}