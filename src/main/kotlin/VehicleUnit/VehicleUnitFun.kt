package VehicleUnit

import Main.ProcessVisitor.UnitVisitor

abstract class VehicleUnitFun : VehicleUnit {
    override val inOrder
        get() = !(malfunction || damage || destroyed)

    override fun combatantValue(): Double {
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
    override fun accept(visitor: UnitVisitor) = visitor.visit(this)
}