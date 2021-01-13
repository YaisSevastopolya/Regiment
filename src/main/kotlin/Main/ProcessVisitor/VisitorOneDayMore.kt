package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Events.OneDayMore
import InfantryUnit.InfantryUnit
import Unit.Unit
import VehicleUnit.VehicleUnit

class VisitorOneDayMore : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        OneDayMore.eat(infantryUnit)
        OneDayMore.illness(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(unit: Unit) {}
}