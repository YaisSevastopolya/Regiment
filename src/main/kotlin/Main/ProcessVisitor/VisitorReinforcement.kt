package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.Reinforcement
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorReinforcement : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {
        Reinforcement.reinforcementCommand(commandUnit)
    }
    override fun visit(infantryUnit: InfantryUnit) {
        Reinforcement.reinforcementInfantry(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(militaryUnit: MilitaryUnit) {}
}