package Main.ProcessVisitor

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import Unit.MilitaryUnit
import VehicleUnit.VehicleUnit

class VisitorTodayReport(
    val countersInfantry: MutableMap<String, Int> = mutableMapOf(),
    val countersVehicle: MutableMap<String, Int> = mutableMapOf(),
) : UnitVisitor {
    override fun visit(commandUnit: CommandUnit) {}
    override fun visit(infantryUnit: InfantryUnit) {
        countersInfantry["По штату"] = countersInfantry.getOrDefault("По штату", 0) + 1
        if (infantryUnit.inOrder) {
            countersInfantry["В строю"] = countersInfantry.getOrDefault("В строю", 0) + 1
        } else {
            countersInfantry["В строю"] = countersInfantry.getOrDefault("В строю", 0)
        }
        if (infantryUnit.isIll) {
            countersInfantry["Болеет"] = countersInfantry.getOrDefault("Болеет",0) + 1
        } else {
            countersInfantry["Болеет"] = countersInfantry.getOrDefault("Болеет",0)
        }
        if (infantryUnit.isWounded) {
            countersInfantry["Ранено"] = countersInfantry.getOrDefault("Ранено",0) + 1
        } else {
            countersInfantry["Ранено"] = countersInfantry.getOrDefault("Ранено",0)
        }
        if (infantryUnit.isKilled) {
            countersInfantry["Убито"] = countersInfantry.getOrDefault("Убито",0) + 1
        } else {
            countersInfantry["Убито"] = countersInfantry.getOrDefault("Убито",0)
        }
        if (infantryUnit.isArrested) {
            countersInfantry["Под арестом"] = countersInfantry.getOrDefault("Под арестом",0) + 1
        } else {
            countersInfantry["Под арестом"] = countersInfantry.getOrDefault("Под арестом",0)
        }
    }
    override fun visit(vehicleUnit: VehicleUnit) {
        countersVehicle["По штату"] = countersVehicle.getOrDefault("По штату", 0) + 1
        if (vehicleUnit.inOrder) {
            countersVehicle["В строю"] = countersVehicle.getOrDefault("В строю", 0) + 1
        } else {
            countersVehicle["В строю"] = countersVehicle.getOrDefault("В строю", 0)
        }
        if (vehicleUnit.malfunction) {
            countersVehicle["Не на ходу"] = countersVehicle.getOrDefault("Не на ходу", 0) + 1
        } else {
            countersVehicle["Не на ходу"] = countersVehicle.getOrDefault("Не на ходу", 0)
        }
        if (vehicleUnit.damage) {
            countersVehicle["Повреждено"] = countersVehicle.getOrDefault("Повреждено", 0) + 1
        } else {
            countersVehicle["Повреждено"] = countersVehicle.getOrDefault("Повреждено", 0)
        }
        if (vehicleUnit.destroyed) {
            countersVehicle["Безвозвратно потеряно"] = countersVehicle.getOrDefault("Безвозвратно потеряно", 0) + 1
        } else {
            countersVehicle["Безвозвратно потеряно"] = countersVehicle.getOrDefault("Безвозвратно потеряно", 0)
        }
    }
    override fun visit(militaryUnit: MilitaryUnit) {}
}