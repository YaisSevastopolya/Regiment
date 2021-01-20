package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Events.OneDayMore
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorOneDayMore : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {
        OneDayMore.lazyCommand(commandUnit)
    }
    override fun visit(infantryUnit: InfantryUnit) {
        OneDayMore.eat(infantryUnit)
        OneDayMore.illness(infantryUnit)
        OneDayMore.lazy(infantryUnit)
        OneDayMore.alcoholism((infantryUnit))
        OneDayMore.crime(infantryUnit)
        OneDayMore.recovery(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {
        OneDayMore.malfunction(vehicleUnit)
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}