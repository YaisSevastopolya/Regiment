package Unit

import Main.ProcessVisitor.UnitVisitor

abstract class MilitaryUnitFun  : MilitaryUnit {
    override fun unitCommandEfficiency(): Double {
        var commandEfficiency = structureCommand[0].commandEfficiency()
        for (i in structureCommand) {
            commandEfficiency += i.commandEfficiency()
        }
        commandEfficiency /= (structureCommand.size + 1).toDouble()
        return commandEfficiency
    }
    override fun combatantValueCommandSum(): Double {
        var combatantValue = 0.0
        for (i in structureCommand) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    override fun combatantValueInfantrySum(): Double {
        var combatantValue = 0.0
        for (i in structureInfantry) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    override fun vehicleEfficiency(): Double {
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
    override fun vehicleSupportEfficiency(): Double {
        val vehicleSupportEfficiency = 1 + (vehicleEfficiency() - 1) / 5
        return vehicleSupportEfficiency
    }
    override fun combatantValueVehicleSum(): Double {
        var combatantValue = 0.0
        for (i in structureVehicle) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    override fun combatantValueUnitSum(): Double {
        var combatantValue = 0.0
        for (i in structureMilitaryUnit) {
            combatantValue += i.combatantValue()
        }
        return combatantValue
    }
    override fun combatantValue() : Double {
        val combatantValue = (
                (combatantValueCommandSum() * vehicleSupportEfficiency())
                        + (combatantValueInfantrySum() * vehicleSupportEfficiency())
                        + (combatantValueVehicleSum() * vehicleEfficiency())
                        + combatantValueUnitSum()
                ) * unitCommandEfficiency()
        return combatantValue
    }
    override fun accept(visitor: UnitVisitor) {
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
        structureMilitaryUnit.forEach{
            it.accept(visitor)
        }
    }
}