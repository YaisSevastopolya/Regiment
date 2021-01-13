package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Events.CombatEpisode
import InfantryUnit.InfantryUnit
import Unit.Unit
import VehicleUnit.VehicleUnit

class VisitorCombatEpisode : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        CombatEpisode.lossesInfantry(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(unit: Unit) {}
}