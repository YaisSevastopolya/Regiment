package InfantryUnit

import Data.*
import Main.ProcessVisitor.UnitVisitor


interface InfantryUnit {
    val position: String
    val inOrder: Boolean
    var isIll: Boolean
    var isWounded: Boolean
    var isKilled: Boolean
    var isArrested: Boolean
    var isFed: Percent
    var isArmed: Boolean
    var isEquipped: Percent
    var isTrained: Percent
    var isBattleTried: Boolean
    var combatExperience: Percent
    var vehicleDriverExperience: Percent
    var vehicleCombatDriverExperience: Percent
    var isAlcoholic: Boolean
    var isSportsman: Boolean

    var name: String
    var surname: String
    var patronymic: String

    val fullName: String

    val basicCombatPower: Double
    fun combatantValue(): Double

    fun vehicleDriverEfficiency(): Double

    fun accept(visitor: UnitVisitor)
}