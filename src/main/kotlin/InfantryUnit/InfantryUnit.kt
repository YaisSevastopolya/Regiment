package InfantryUnit

import Data.*
import Main.ProcessVisitor.UnitVisitor


interface InfantryUnit {
    val position: String
    var inOrder: Boolean //inOrder может быть с подпунктами?
    var isFed: Percent
    var isArmed: Boolean
    var isEquipped: Percent
    var isTrained: Percent
    var isBattleTried: Boolean
    var combatExperience: Percent
    var vehicleDriverExperience: Percent
    var vehicleCombatDriverExperience: Percent

    fun fullName() : String {
        val name = Data.name.random()
        val surname = Data.surname.random()
        val patronymic = Data.patronymic.random()
        return "$surname $name $patronymic"
    }

    val basicCombatPower: Double

    fun combatantValue() : Double {
        var combatantValue = 0.0

        if (inOrder && isArmed) {
            val fed = isFed.toDouble()
            val equipped = isEquipped.toDouble()
            var combatPower = basicCombatPower
            if (fed < 1.0) {
                combatPower *= 0.1
            }
            else if (fed < 10.0) {
                combatPower *= 0.5
            }
            if (equipped < 1.0) {
                combatPower *= 0.1
            }
            else if (equipped < 10.0) {
                combatPower *= 0.5
            }

            val trained = isTrained.toDouble()
            combatPower *= (trained / 100 * 3)     //равновесное состояние тренированности - 33%

            if (isBattleTried) {
                val combatExperience = combatExperience.toDouble()
                combatPower *= ((combatExperience / 100) * 5 + 1.5)     //обстрелянный личный состав сразу на 50% боеспособнее
            }

            combatantValue = combatPower
        }
        return combatantValue
    }

    fun vehicleDriverEfficiency(): Double {
        val vehicleDriverExperience = vehicleDriverExperience.toDouble()
        val vehicleCombatDriverExperience = vehicleCombatDriverExperience.toDouble()
        var vehicleDriverEfficiency = 0.0
        if (vehicleDriverExperience > 50.0) {                   //Водительский опыт ниже 50% не позволит управлять машиной
            vehicleDriverEfficiency = vehicleDriverExperience / 100
        }
        if (isBattleTried) {
            vehicleDriverEfficiency *= ((vehicleCombatDriverExperience / 100) * 5 + 1.5)
        }

        return vehicleDriverEfficiency
    }

    fun accept(visitor: UnitVisitor) = visitor.visit(this)
}