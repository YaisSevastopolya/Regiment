package InfantryUnit

import Data.Data
import Main.ProcessVisitor.UnitVisitor
import kotlin.random.Random

abstract class InfantryUnitFun : InfantryUnit {

    override var name = Data.name.random()
    override var surname = Data.surname.random()
    override var patronymic = Data.patronymic.random()

    override val fullName
        get() = ("${surname} ${name} ${patronymic}")

    override val inOrder
        get() = !(isIll || isWounded || isKilled || isArrested)

    override fun combatantValue(): Double {
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

            if (isAlcoholic) {
                combatPower *= (Random.nextInt(20,120 + 1) / 100)
            }

            if (isSportsman) {
                combatPower *= 1.1
            }

            if (isBattleTried) {
                val combatExperience = combatExperience.toDouble()
                combatPower *= ((combatExperience / 100) * 5 + 1.5)     //обстрелянный личный состав сразу на 50% боеспособнее
            }

            combatantValue = combatPower
        }
        return combatantValue
    }
    override fun vehicleDriverEfficiency(): Double {
        val vehicleDriverExperience = vehicleDriverExperience.toDouble()
        val vehicleCombatDriverExperience = vehicleCombatDriverExperience.toDouble()
        var vehicleDriverEfficiency = 0.0
        if (vehicleDriverExperience > 50.0) {                   //Водительский опыт ниже 50% не позволит управлять машиной
            vehicleDriverEfficiency = vehicleDriverExperience / 100
        }
        if (isAlcoholic) {
            vehicleDriverEfficiency *= (Random.nextInt(20,120 + 1) / 100)
        }
        if (isBattleTried) {
            vehicleDriverEfficiency *= ((vehicleCombatDriverExperience / 100) * 5 + 1.5)
        }

        return vehicleDriverEfficiency
    }
    override fun accept(visitor: UnitVisitor) = visitor.visit(this)
}