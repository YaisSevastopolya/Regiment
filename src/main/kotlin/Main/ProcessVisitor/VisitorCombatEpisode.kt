package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Events.CombatEpisode
import Events.OneDayMore
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorCombatEpisode : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {
        CombatEpisode.commandCombatExperience(commandUnit)
    }
    override fun visit(infantryUnit: InfantryUnit) {
        CombatEpisode.lossesInfantry(infantryUnit)
        CombatEpisode.infantryCombat(infantryUnit)
        CombatEpisode.combatExperience(infantryUnit)
        OneDayMore.eat(infantryUnit)
        OneDayMore.illness(infantryUnit)
        OneDayMore.recovery(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {
        CombatEpisode.vehicleUsing(vehicleUnit)
        CombatEpisode.vehicleDamage(vehicleUnit)
        OneDayMore.malfunction(vehicleUnit)
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}