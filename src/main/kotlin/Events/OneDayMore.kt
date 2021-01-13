package Events

import InfantryUnit.InfantryUnit
import kotlin.random.Random

object OneDayMore {
    fun eat(infantryUnit: InfantryUnit) {
        infantryUnit.isFed -= 10
    }
    fun illness(infantryUnit: InfantryUnit) {
        val chance_a = Random.nextInt(1, 4)
        val chance_b = Random.nextInt(1, 4)
        if (chance_a == chance_b) {
            infantryUnit.inOrder = false
        }
    }
    // Добавить влияние события на все аспекты жизнедеятельности подразделения
}