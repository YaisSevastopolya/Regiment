package Unit

import CommandUnit.CommandUnit
import InfantryUnit.InfantryUnit
import Main.ProcessVisitor.UnitVisitor
import VehicleUnit.VehicleUnit

interface MilitaryUnit {
    val structureCommand: List<CommandUnit>
    fun unitCommandEfficiency(): Double
    fun combatantValueCommandSum(): Double

    val structureInfantry: List<InfantryUnit>
    fun combatantValueInfantrySum(): Double

    val structureVehicle: List<VehicleUnit>
    val maxCrew: Int
    val minCrew: Int
    fun vehicleEfficiency(): Double
    fun vehicleSupportEfficiency(): Double
    fun combatantValueVehicleSum(): Double

    val structureMilitaryUnit: List<MilitaryUnit>
    fun combatantValueUnitSum(): Double
    fun combatantValue(): Double

    fun accept(visitor: UnitVisitor)
}