package VehicleUnit

import Data.Percent
import Main.ProcessVisitor.UnitVisitor

interface VehicleUnit {
    val position: String
    val inOrder: Boolean
    var malfunction: Boolean
    var damage: Boolean
    var destroyed: Boolean
    var isArmed: Boolean
    var isEquipped: Percent
    var isFueled: Percent

    val maxCrew: Int
    val minCrew: Int

    val basicCombatPower: Double
    fun combatantValue(): Double

    fun accept(visitor: UnitVisitor)
}