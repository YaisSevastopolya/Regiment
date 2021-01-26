package Main.ProcessVisitor

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorTodayReport(
    val countersInfantry: MutableMap<String, Int> = mutableMapOf(),
    val countersVehicle: MutableMap<String, Int> = mutableMapOf(),
) : UnitVisitor {
    fun numbers(propertyState: Boolean, propertyName: String, counters: MutableMap<String, Int>) {
        if (propertyState) {
            counters[propertyName] = counters.getOrDefault(propertyName, 0) + 1
        } else {
            counters[propertyName] = counters.getOrDefault(propertyName, 0)
        }
    }
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        numbers(true, "По штату", countersInfantry)
        numbers(infantryUnit.inOrder, "В строю", countersInfantry)
        numbers(infantryUnit.isIll, "Болеет", countersInfantry)
        numbers(infantryUnit.isWounded, "Ранено", countersInfantry)
        numbers(infantryUnit.isKilled, "Убито", countersInfantry)
        numbers(infantryUnit.isArrested, "Под арестом", countersInfantry)
    }
    override fun visit(vehicleUnit: VehicleUnit) {
        numbers(true, "По штату", countersVehicle)
        numbers(vehicleUnit.inOrder, "В строю", countersVehicle)
        numbers(vehicleUnit.malfunction, "Не на ходу", countersVehicle)
        numbers(vehicleUnit.damage, "Повреждено", countersVehicle)
        numbers(vehicleUnit.destroyed, "Безвозвратно потеряно", countersVehicle)
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}