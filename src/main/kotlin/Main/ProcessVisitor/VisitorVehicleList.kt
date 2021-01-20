package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Data.Data
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorVehicleList(val x: MutableMap<String, Int> = mutableMapOf()) : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {}
    override fun visit(vehicleUnit: VehicleUnit) {
        x[(Data.database[vehicleUnit.position] ?: error("")).position] = x.getOrDefault((Data.database[vehicleUnit.position] ?: error("")).position, 0) + 1
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}