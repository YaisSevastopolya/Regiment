package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.PersonnelList
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorPersonnelList(var i: Int = 1) : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        print("$i ")
        PersonnelList.personnelListInfantry(infantryUnit)
        i++
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(militaryUnit: MilitaryUnit) {}
}