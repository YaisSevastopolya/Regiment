package Main.ProcessVisitor

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit

import VehicleUnit.VehicleUnit

interface UnitVisitor {
    fun visit(commandUnit: CommandUnit)
    fun visit(infantryUnit: InfantryUnit)
    fun visit(vehicleUnit: VehicleUnit)
    fun visit(militaryUnit: MilitaryUnit)
}