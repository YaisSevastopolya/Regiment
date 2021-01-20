package Main.ProcessVisitor

import CommandUnit.CommandUnit
import Decisions.ServiceCharacteristic
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorServiceCharacteristic (var i: Int = 1) : UnitVisitor{
    fun playerChoice(): Int {
        if (i == 1) {
            val playerChoice = readLine() ?: ""
            return playerChoice.toInt()
        } else {
            return 0
        }
    }
    val x = playerChoice()
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        if (i == x)
        ServiceCharacteristic.serviceCharacteristicInfantry(infantryUnit)
        i++
    }
    override fun visit(vehicleUnit: VehicleUnit) {}
    override fun visit(militaryUnit: MilitaryUnit) {}
}