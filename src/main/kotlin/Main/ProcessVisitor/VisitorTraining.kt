package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.Training
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorTraining : UnitVisitor{
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        Training.training(infantryUnit)
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(militaryUnit: MilitaryUnit) {}
}