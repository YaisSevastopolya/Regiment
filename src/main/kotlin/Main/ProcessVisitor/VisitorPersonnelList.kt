package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.PersonnelList
import InfantryUnit.InfantryUnit
import Unit.Unit
import VehicleUnit.VehicleUnit

class VisitorPersonnelList(var i: Int = 1) : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {
        print("$i ")
        PersonnelList.personnelListCommand(commandUnit)
        i++
    }
    override fun visit(infantryUnit: InfantryUnit) {
        print("$i ")
        PersonnelList.personnelListInfantry(infantryUnit)
        i++
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(unit: Unit) {}
}