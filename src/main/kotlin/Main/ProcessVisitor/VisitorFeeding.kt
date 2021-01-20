package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.Feeding
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorFeeding : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        Feeding.feeding(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(militaryUnit: MilitaryUnit) {}
}