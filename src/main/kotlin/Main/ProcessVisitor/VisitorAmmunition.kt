package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.Ammunition
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorAmmunition : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        Ammunition.ammunition(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {
        Ammunition.ammunition(vehicleUnit)
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}