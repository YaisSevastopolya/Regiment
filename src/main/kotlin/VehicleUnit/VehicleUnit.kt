package VehicleUnit

import Data.Percent
import Main.ProcessVisitor.UnitVisitor

interface VehicleUnit {
    val position: String
    var inOrder: Boolean
    var isArmed: Boolean
    var isEquipped: Percent
    var isFueled: Percent

    val maxCrew: Int
    val minCrew: Int

    val basicCombatPower: Double

    fun combatantValue() : Double {
        var combatantValue = 0.0
        if (inOrder && isArmed) {
            val equipped = isEquipped.toDouble()
            val fueled = isFueled.toDouble()
            var combatPower = basicCombatPower
            if (equipped < 1.0) {
                combatPower *= 0.1
            }
            else if (equipped < 10.0) {
                combatPower *= 0.5
            }
            if (fueled < 1.0) {
                combatPower *= 0.1
            }
            else if (fueled < 10.0) {
                combatPower *= 0.5
            }
            combatantValue = combatPower
        }
        return combatantValue
    }

    fun accept(visitor: UnitVisitor) = visitor.visit(this)
}